package com.signavio.data.insight.kafka.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class KafkaTemplateEndpoint {

  private final KafkaTemplateService service;

  public KafkaTemplateEndpoint(KafkaTemplateService service) {
    this.service = service;
  }

  @GetMapping("/health")
  public ResponseEntity<String> health() {
    return new ResponseEntity<>("{\"health\": \"ok\"}", OK);
  }

  @PostMapping("/message/{message}")
  public ResponseEntity<String> message(@PathVariable String message) {
    return new ResponseEntity<>(service.publishMessage(message), OK);
  }
}