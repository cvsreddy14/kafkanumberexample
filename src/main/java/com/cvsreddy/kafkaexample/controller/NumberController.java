package com.cvsreddy.kafkaexample.controller;
import org.springframework.http.ResponseEntity;
import com.cvsreddy.kafkaexample.producer.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    private final KafkaProducerService kafkaProducerService;

    public NumberController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/sendNumbers")
    public ResponseEntity<String> sendNumbers(@RequestParam(value = "number") Integer number) {
        if (number == null || number <= 0) {
            return ResponseEntity.badRequest().body("Invalid number parameter. Please provide a positive integer.");
        }
        for (int i = 1; i <= number; i++) {

            kafkaProducerService.sendNumberToKafka(String.valueOf(i));
        }
        return ResponseEntity.ok("Sent " + number + " numbers to Kafka.");
    }

}
