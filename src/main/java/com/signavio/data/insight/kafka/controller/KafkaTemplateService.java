package com.signavio.data.insight.kafka.controller;

import static java.lang.String.format;

import com.signavio.data.insight.kafka.config.KafkaProducerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaTemplateService {

  private final KafkaProducerService<String, String> producerService;

  public KafkaTemplateService(KafkaProducerService<String, String> producerService) {
    this.producerService = producerService;
  }

  public String publishMessage(String message) {
    producerService.send(message);
    return message;
  }

  @Scheduled(fixedDelay = 10000)
  public void pingMessages() {
    producerService.send(format("ping-%s", System.currentTimeMillis()));
  }
}