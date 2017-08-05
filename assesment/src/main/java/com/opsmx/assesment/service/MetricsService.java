package com.opsmx.assesment.service;

import com.opsmx.assesment.exception.ApplicationException;
import com.opsmx.assesment.model.Metric;
import com.opsmx.assesment.model.MetricsGroup;

/**
 * Service class defines the api methods to access metrics resource.
 * 
 * @author sandeep
 *
 */
public interface MetricsService {

	public Metric getMetric(String name) throws ApplicationException;

	public MetricsGroup getMetricGroup(String name) throws ApplicationException;
}
