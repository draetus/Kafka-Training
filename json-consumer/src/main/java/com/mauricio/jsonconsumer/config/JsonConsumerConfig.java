package com.mauricio.jsonconsumer.config;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class JsonConsumerConfig {
	
	private final KafkaProperties properties;
	
	@Bean
	public ConsumerFactory<String, Object> jsonConsumerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configs);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory jsonContainerFactory(ConsumerFactory<String, Object> jsonConsumerFactor) {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
		factory.setConsumerFactory(jsonConsumerFactor);
		factory.setMessageConverter(new JsonMessageConverter());
		return factory;
	}
}
