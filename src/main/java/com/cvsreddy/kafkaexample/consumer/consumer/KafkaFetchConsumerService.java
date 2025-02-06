package com.cvsreddy.kafkaexample.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaFetchConsumerService {

    private final List<Integer> consumedNumbers = new ArrayList<>();

    @KafkaListener(topics = "numbers-topic", groupId = "test-group")
    public void consumeNumber(Integer number) {
        System.out.println("Consumed number: " + number);
        synchronized (consumedNumbers) {
            consumedNumbers.add(number);
        }
    }

    public List<Integer> getConsumedNumbers() {
        synchronized (consumedNumbers) {
            return new ArrayList<>(consumedNumbers);  // Return a copy to avoid concurrent modification issues
        }
    }
}
