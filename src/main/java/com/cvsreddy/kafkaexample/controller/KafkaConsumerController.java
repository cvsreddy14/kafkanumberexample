package com.cvsreddy.kafkaexample.controller;

import com.cvsreddy.kafkaexample.consumer.KafkaConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumerController {

    private final KafkaConsumerService kafkaConsumerService;

    public KafkaConsumerController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @GetMapping("/consumeKafkaData")
    public String consumeKafkaData() {
        // Trigger Kafka consumer directly
        kafkaConsumerService.startConsuming();
        return "Started consuming data from Kafka.";
    }
}
