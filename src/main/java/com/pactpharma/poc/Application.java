package com.pactpharma.poc;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.converter.Jackson2JavaTypeMapper.TypePrecedence;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

import com.pactpharma.poc.model.Clinical2;
import com.pactpharma.poc.model.Lab2;

/**
 * Demonstrates EDMService.
 *
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * Boot will autowire this into the container factory.
	 */
	@Bean
	public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
		return new SeekToCurrentErrorHandler(
				new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
	}

	@Bean
	public RecordMessageConverter converter() {
		StringJsonMessageConverter converter = new StringJsonMessageConverter();
		DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
		typeMapper.setTypePrecedence(TypePrecedence.TYPE_ID);
		typeMapper.addTrustedPackages("com.pactpharma.poc.model");
		Map<String, Class<?>> mappings = new HashMap<>();
		mappings.put("lab", Lab2.class);
		mappings.put("clinical", Clinical2.class);
		typeMapper.setIdClassMapping(mappings);
		converter.setTypeMapper(typeMapper);
		return converter;
	}

	@Bean
	public NewTopic labs() {
		return new NewTopic("labs", 1, (short) 1);
	}

	@Bean
	public NewTopic clinicals() {
		return new NewTopic("clinicals", 1, (short) 1);
	}

}
