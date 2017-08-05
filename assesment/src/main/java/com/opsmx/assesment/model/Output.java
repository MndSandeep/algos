package com.opsmx.assesment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {
	private List<MetricsGroup> results;

	public List<MetricsGroup> getResults() {
		return results;
	}

	public void setResults(List<MetricsGroup> results) {
		this.results = results;
	}
}
