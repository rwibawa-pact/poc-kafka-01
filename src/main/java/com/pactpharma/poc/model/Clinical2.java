package com.pactpharma.poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Clinical2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String source;
}
