package com.mauricio.strproducer.config;

import static org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {
	
	private final KafkaProperties properties;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		var configs = new HashMap<String, Object>();
		configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		return new KafkaAdmin(configs);
	}
	
	@Bean
	public KafkaAdmin.NewTopics newTopics(KafkaAdmin kafkaAdmin) {
		return new KafkaAdmin.NewTopics(
				TopicBuilder.name("payment-topic").partitions(1).build()
			);
	}

}
