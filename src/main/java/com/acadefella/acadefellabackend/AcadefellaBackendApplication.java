package com.acadefella.acadefellabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class})
public class AcadefellaBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(AcadefellaBackendApplication.class, args);
  }
}
