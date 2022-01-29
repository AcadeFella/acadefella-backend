package com.acadefella.acadefellabackend.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ReadConcern;
import com.mongodb.WriteConcern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
@Configuration
@Profile("test")
@EnableMongoRepositories(
    basePackageClasses = {
      //                ClaimDebtorMongoDBEntityPackageMarker.class,
    })
public class MongoDBConfigTestEnvironment extends MongoDBConfig {

  @Override
  protected void configureClientSettings(MongoClientSettings.Builder builder) {
    // customization hook
    builder
        .codecRegistry(super.getCodedRegistry())
        .readConcern(ReadConcern.SNAPSHOT)
        .writeConcern(WriteConcern.MAJORITY)
        .applyConnectionString(new ConnectionString(super.connectionURITemplate));
  }
}
