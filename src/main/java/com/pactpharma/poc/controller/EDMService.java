package com.pactpharma.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactpharma.poc.model.Clinical1;
import com.pactpharma.poc.model.Lab1;

/**
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
@RestController
public class EDMService {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	@PostMapping(path = "/send/lab/{id}")
	public void sendFoo(@PathVariable String id) {
		this.template.send("labs", new Lab1(id));
	}

	@PostMapping(path = "/send/clinical/{source}")
	public void sendBar(@PathVariable String source) {
		this.template.send("clinicals", new Clinical1(source));
	}

	@PostMapping(path = "/send/unknown/{what}")
	public void sendUnknown(@PathVariable String what) {
		this.template.send("clinicals", what);
	}

}
