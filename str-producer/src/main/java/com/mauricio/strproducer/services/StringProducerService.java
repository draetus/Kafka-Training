package com.mauricio.strproducer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StringProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("str-topic", message).addCallback(
			success -> {
				if (success != null) {
					log.info("Send message with success {}", message);
					log.info("partition {}, Offset {}", 
							success.getRecordMetadata().partition(),
							success.getRecordMetadata().offset());
				}
			},
			erro -> log.error("Error send message")
				);;
	}

}
