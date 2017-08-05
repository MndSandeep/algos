package com.opsmx.assesment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MetricsGroup model class holds the group of metrics objects
 * 
 * @author sandeep
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricsGroup {
	private double groupScore;
	private String groupColor;
	private String name;
	private int groupRelevance;
	private List<Metric> metricList;
	private long failedMetrics;

	public double getGroupScore() {
		return groupScore;
	}

	public void setGroupScore(double groupScore) {
		this.groupScore = groupScore;
	}

	public String getGroupColor() {
		return groupColor;
	}

	public void setGroupColor(String groupColor) {
		this.groupColor = groupColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupRelevance() {
		return groupRelevance;
	}

	public void setGroupRelevance(int groupRelevance) {
		this.groupRelevance = groupRelevance;
	}

	public List<Metric> getMetricList() {
		return metricList;
	}

	public void setMetricList(List<Metric> metricList) {
		this.metricList = metricList;
	}

	public long getFailedMetrics() {
		return failedMetrics;
	}

	public void setFailedMetrics(long failedMetrics) {
		this.failedMetrics = failedMetrics;
	}

}
