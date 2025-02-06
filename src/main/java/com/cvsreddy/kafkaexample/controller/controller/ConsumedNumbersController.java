package com.cvsreddy.kafkaexample.controller.controller;

import com.cvsreddy.kafkaexample.consumer.consumer.KafkaFetchConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumedNumbersController {

    private final KafkaFetchConsumerService kafkaFetchConsumerService;

    public ConsumedNumbersController(KafkaFetchConsumerService kafkaFetchConsumerService) {
        this.kafkaFetchConsumerService = kafkaFetchConsumerService;
    }

    @GetMapping("/getConsumedNumbers")
    public List<Integer> getConsumedNumbers() {
        return kafkaFetchConsumerService.getConsumedNumbers();
    }
}
