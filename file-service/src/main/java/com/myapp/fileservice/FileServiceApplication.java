package com.myapp.fileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories("com.myapp.fileservice")
public class FileServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileServiceApplication.class, args);
  }

}
