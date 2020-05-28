package com.pactpharma.poc.component;

import com.pactpharma.poc.repo.ClinicalRepository;
import com.pactpharma.poc.repo.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ClinicalRepository clinicalRepository;

	@Autowired
	private LabRepository labRepository;

	@KafkaHandler
	public void foo(Lab2 lab) {
		System.out.println("Received: " + lab);
		labRepository.save(lab);
	}

	@KafkaHandler
	public void bar(Clinical2 clinical) {
		System.out.println("Received: " + clinical);
		clinicalRepository.save(clinical);
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		System.out.println("Received unknown: " + object);
	}

}
