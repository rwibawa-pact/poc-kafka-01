package com.pactpharma.poc.component;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pactpharma.poc.model.Clinical2;
import com.pactpharma.poc.model.Lab2;

/**
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
@Component
@KafkaListener(id = "multiGroup", topics = { "labs", "clinicals" })
public class EDMHandlers {

	@KafkaHandler
	public void foo(Lab2 id) {
		System.out.println("Received: " + id);
	}

	@KafkaHandler
	public void bar(Clinical2 source) {
		System.out.println("Received: " + source);
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		System.out.println("Received unknown: " + object);
	}

}
