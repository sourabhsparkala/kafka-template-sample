package com.signavio.data.insight.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableScheduling
@SpringBootApplication
public class KafkaTemplateApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaTemplateApplication.class, args);
  }

}
