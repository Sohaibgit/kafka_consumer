package com.spring.kafka.controller;

import com.spring.kafka.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class KafkaConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerController.class);

    @KafkaListener(groupId = "group-id-1", topics = "mytopic1", containerFactory = "stringKafkaListenerContainerFactory")
    public String consumeStringMessage(String data){
        LOGGER.info("string data: {}", data);
        return data;
    }

    @KafkaListener(groupId = "group-id-2", topics = "mytopic1", containerFactory = "userKafkaListenerContainerFactory")
    public User consumeUserObject(User user){
        LOGGER.info("user object: {}", user);
        return user;
    }
}
