package com.opsmx.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {
	private Output canary_output;

	public Output getCanary_output() {
		return canary_output;
	}

	public void setCanary_output(Output canary_output) {
		this.canary_output = canary_output;
	}
}
