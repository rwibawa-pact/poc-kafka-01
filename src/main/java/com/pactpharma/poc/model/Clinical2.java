package com.pactpharma.poc.model;

/**
 * @author Ryan Wibawa
 * @since 0.0.1
 *
 */
public class Clinical2 {

	private String source;

	public Clinical2() {
	}

	public Clinical2(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Clinical2 [source=" + this.source + "]";
	}

}
