package com.acadefella.acadefellabackend.config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.MapCodec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.SessionSynchronization;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Slf4j
public abstract class MongoDBConfig extends AbstractMongoClientConfiguration {

  @Value("${mongodb.database}")
  private String database;

  @Value("${mongodb.uri}")
  protected String connectionURITemplate;

  @Value("${mongodb.username}")
  protected String username;

  @Value("${mongodb.password}")
  protected String password;

  @Override
  protected boolean autoIndexCreation() {
    return false;
  }

  @Override
  public MongoCustomConversions customConversions() {
    return MongoDBCustomConverters.createCustomConverters();
  }

  @Bean
  @Override
  public MongoClient mongoClient() {
    // only for testing settings
    var mongoClient = super.mongoClient();
    log.info(
        "Mongoclient settings readconcern {} writeconcern {}",
        mongoClient.getDatabase(database).getReadConcern().asDocument().toString(),
        mongoClient.getDatabase(database).getWriteConcern().toString());
    return mongoClient;
  }

  @Bean
  @Primary
  public MongoTemplate mongoTemplate(MongoClient mongoClient) {
    log.info("###### we want an output");
    var mongoTemplate = new MongoTemplate(mongoClient, getDatabaseName());
    mongoTemplate.setSessionSynchronization(SessionSynchronization.ALWAYS);

    var converter = (MappingMongoConverter) mongoTemplate.getConverter();
    converter.setMapKeyDotReplacement(".");
    converter.setCustomConversions(this.customConversions());

    return mongoTemplate;
  }

  @Override
  protected String getDatabaseName() {
    return database;
  }

  protected CodecRegistry getCodedRegistry() {
    return fromRegistries(
        MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(
            PojoCodecProvider.builder().automatic(true).register(MapCodec.class).build()));
  }

  @Bean
  MongoTransactionManager transactionManager(MongoDatabaseFactory databaseFactory) {
    return new MongoTransactionManager(databaseFactory);
  }
}
