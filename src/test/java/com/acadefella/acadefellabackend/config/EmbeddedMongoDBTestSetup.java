package com.acadefella.acadefellabackend.config;

import com.mongodb.BasicDBList;
import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongoCmdOptions;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.config.Storage;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public abstract class EmbeddedMongoDBTestSetup {
  private static String database;
  private static String connectionString;
  private static String replicaSet;
  private static int node1Port;
  private static MongodExecutable node1MongodExe;
  private static MongodProcess node1Mongod;
  private static int node2Port;
  private static MongodExecutable node2MongodExe;
  private static MongodProcess node2Mongod;

  static {
    var properties = new Properties();
    var url =
        EmbeddedMongoDBTestSetup.class.getClassLoader().getResource("application-test.properties");
    try {
      URI uri = new URI(url.getFile());
      properties.load(new FileInputStream(uri.getPath()));
      node1Port = Integer.parseInt(properties.getProperty("mongodb.port"));
      node2Port = Integer.parseInt(properties.getProperty("mongodb.port2"));
      database = properties.getProperty("mongodb.database");
      replicaSet = properties.getProperty("mongodb.replicaSet");
      connectionString =
          String.format(
              "mongodb://localhost:%d,localhost:%d/%s?retryWrites=true&w=majority&r=majority&replset=%s",
              node1Port, node2Port, database, replicaSet);
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @AfterAll
  static void destroyEmbeddedMongoDBInstance() {
    System.out.println("Shutting down Embedded Mongo DB...");

    if (node1Mongod != null) {
      node1MongodExe.stop();
    }
    if (node1Mongod != null) {
      node1Mongod.stop();
    }
    if (node2Mongod != null) {
      node2MongodExe.stop();
    }
    if (node2Mongod != null) {
      node2Mongod.stop();
    }
  }

  @BeforeAll
  static void startMongoEmbedded() throws IOException {
    System.out.println("Starting Embedded Mongo DB...");

    var runtime = MongodStarter.getDefaultInstance();

    node1MongodExe =
        runtime.prepare(
            MongodConfig.builder()
                .version(Version.Main.V4_0)
                .replication(new Storage(null, replicaSet, 5000))
                .cmdOptions(MongoCmdOptions.builder().useNoJournal(false).build())
                .net(new Net(node1Port, Network.localhostIsIPv6()))
                .build());
    node1Mongod = node1MongodExe.start();

    node2MongodExe =
        runtime.prepare(
            MongodConfig.builder()
                .version(Version.Main.V4_0)
                .replication(new Storage(null, replicaSet, 5000))
                .cmdOptions(MongoCmdOptions.builder().useNoJournal(false).build())
                .net(new Net(node2Port, Network.localhostIsIPv6()))
                .build());
    node2Mongod = node2MongodExe.start();

    configureReplicaSetInAdminDB();
    initializeCollections();
  }

  private static void initializeCollections() {
    var appMongoClient = MongoClients.create(connectionString);

    var applicationDatabase = appMongoClient.getDatabase(database);
    applicationDatabase.createCollection("claim-purchase-intent-domain-event");
    applicationDatabase.createCollection("claim-purchase-intent-state");
    applicationDatabase.createCollection("loan-product");
    applicationDatabase.createCollection("claim-debtor");
    applicationDatabase.createCollection("claim-outgoing-event");
    appMongoClient.close();
  }

  private static void configureReplicaSetInAdminDB() {
    var adminConnectionString =
        String.format("mongodb://localhost:%d/?replset=%s", node1Port, replicaSet);
    var adminMongoClient = MongoClients.create(adminConnectionString);

    var adminDatabase = adminMongoClient.getDatabase("admin");

    var config = new Document("_id", replicaSet);
    var members = new BasicDBList();
    members.add(new Document("_id", 0).append("host", "localhost:" + node1Port));
    members.add(new Document("_id", 1).append("host", "localhost:" + node2Port));
    config.put("members", members);

    adminDatabase.runCommand(new Document("replSetInitiate", config));

    System.out.println(">>>>>>>>" + adminDatabase.runCommand(new Document("replSetGetStatus", 1)));
    adminMongoClient.close();
  }
}
