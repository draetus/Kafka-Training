package com.mauricio.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListerner {
	
	@KafkaListener(groupId = "group-1", 
			topicPartitions = { 
					@TopicPartition(topic = "str-topic", partitions = {"0"}) //OPCIONAL, CASO NÃO SETADO A PARTITION O KAFKA DIRECIONA AUTOMATICAMENTE
			},
			containerFactory = "strContainerFactory")
	public void listener(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-1", 
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"1"})
			}, 
			containerFactory = "strContainerFactory")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}

}
