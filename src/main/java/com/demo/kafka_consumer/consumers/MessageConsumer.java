package com.demo.kafka_consumer.consumers;

import com.demo.kafka_consumer.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

//    @KafkaListener(topics = "ravitopic6",groupId = "6th-group")
//    public void messageListener1(String message) {
//        try {
//            logger.info("consumer1 message successufully:{}",message);
//        } catch (Exception e) {
//            logger.error("error occurred while consuming message:{}",e.getMessage());
//        }
//    }
//
//    @KafkaListener(topics = "ravitopic6",groupId = "6th-group")
//    public void messageListener2(String message) {
//        try {
//            logger.info("consumer2 message successufully:{}",message);
//        } catch (Exception e) {
//            logger.error("error occurred while consuming message:{}",e.getMessage());
//        }
//    }
//
//    @KafkaListener(topics = "ravitopic6",groupId = "6th-group")
//    public void messageListener3(String message) {
//        try {
//            logger.info("consumer3 message successufully:{}",message);
//        } catch (Exception e) {
//            logger.error("error occurred while consuming message:{}",e.getMessage());
//        }
//    }
//
//    @KafkaListener(topics = "ravitopic6",groupId = "6th-group")
//    public void messageListener4(String message) {
//        try {
//            logger.info("consumer4 message successufully:{}",message);
//        } catch (Exception e) {
//            logger.error("error occurred while consuming message:{}",e.getMessage());
//        }
//    }

    //    ,topicPartitions = {@TopicPartition(topic = "topic-ravi-puja",partitions = {"2"})}

    @RetryableTopic(attempts = "4") // N-1 attempts
    @KafkaListener(topics = "topic-ravi-puja",groupId = "dec23-group")
    public void customerListener(String message) {
        try {
            if(message.contains("ravi")) {
                throw new RuntimeException("Message should not contain ravi");
            }
            logger.info("consumed message successfully:{}",message.toString());
        } catch (Exception e) {
            logger.error("error occurred while consuming message:",e);
        }
    }

    @DltHandler
    public void handleFailedEvents(String message) {
        logger.info("Failed message:{}",message);
    }
}
