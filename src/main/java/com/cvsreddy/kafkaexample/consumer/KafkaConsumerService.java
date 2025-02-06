package com.cvsreddy.kafkaexample.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private boolean consuming = false;

    // KafkaListener listens to the Kafka topic and processes the data automatically
    @KafkaListener(topics = "numbers-topic", groupId = "test-group")
    public void consumeNumber(Integer number) {
        if (consuming) {
            System.out.println("Consumed number: " + number);
        }
    }

    // Method to trigger consumption manually
    public void startConsuming() {
        // Enable the consumption flag
        consuming = true;
        System.out.println("Consuming Kafka data now...");
    }

    // You can stop consuming if needed
    public void stopConsuming() {
        consuming = false;
        System.out.println("Stopped consuming Kafka data.");
    }
}
