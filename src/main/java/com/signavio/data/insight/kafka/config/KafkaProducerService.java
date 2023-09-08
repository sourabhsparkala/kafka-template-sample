package com.signavio.data.insight.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService<K, V> {

  private final static Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);

  @Value("${topic.name.producer}")
  private String topicName;

  private final KafkaTemplate<K, V> kafkaTemplate;

  public KafkaProducerService(KafkaTemplate<K, V> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(V message) {
    kafkaTemplate.send(topicName, message);
    LOG.info("Sent message='{}' to topic='{}'", message, topicName);
  }
}
