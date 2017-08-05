package com.opsmx.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model class holds the data related to metric entity.
 * 
 * @author sandeep
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metric {
	/**
	 * Instance variables
	 */

	private String metricType;
	private int metricScore;
	private String metricName;
	private String metricColor;
	private String metricError;
	private int relevance;

	/**
	 * Setters & Getters
	 */

	public String getMetricType() {
		return metricType;
	}

	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}

	public int getMetricScore() {
		return metricScore;
	}

	public void setMetricScore(int metricScore) {
		this.metricScore = metricScore;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public String getMetricColor() {
		return metricColor;
	}

	public void setMetricColor(String metricColor) {
		this.metricColor = metricColor;
	}

	public String getMetricError() {
		return metricError;
	}

	public void setMetricError(String metricError) {
		this.metricError = metricError;
	}

	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((metricColor == null) ? 0 : metricColor.hashCode());
		result = prime * result + ((metricError == null) ? 0 : metricError.hashCode());
		result = prime * result + ((metricName == null) ? 0 : metricName.hashCode());
		result = prime * result + metricScore;
		result = prime * result + ((metricType == null) ? 0 : metricType.hashCode());
		result = prime * result + relevance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metric other = (Metric) obj;
		if (metricColor == null) {
			if (other.metricColor != null)
				return false;
		} else if (!metricColor.equals(other.metricColor))
			return false;
		if (metricError == null) {
			if (other.metricError != null)
				return false;
		} else if (!metricError.equals(other.metricError))
			return false;
		if (metricName == null) {
			if (other.metricName != null)
				return false;
		} else if (!metricName.equals(other.metricName))
			return false;
		if (metricScore != other.metricScore)
			return false;
		if (metricType == null) {
			if (other.metricType != null)
				return false;
		} else if (!metricType.equals(other.metricType))
			return false;
		if (relevance != other.relevance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Metric [metricType=" + metricType + ", metricScore=" + metricScore + ", metricName=" + metricName
				+ ", metricColor=" + metricColor + ", metricError=" + metricError + ", relevance=" + relevance + "]";
	}

}
