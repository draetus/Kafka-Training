package com.mauricio.paymentproducer.config;

import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class JsonProducerConfig {
	
	private final KafkaProperties properties;
	
	@Bean
	public ProducerFactory jsonProducerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
	}
	
	@Bean
	public KafkaTemplate<String, Serializable> kafkaTemplate(ProducerFactory jsonProducerFactory) {
		return new KafkaTemplate<>(jsonProducerFactory);
	}

}
