package com.pactpharma.poc.model;

/**
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
public class Lab2 {

	private String id;

	public Lab2() {
	}

	public Lab2(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Lab2 [id=" + this.id + "]";
	}

}
