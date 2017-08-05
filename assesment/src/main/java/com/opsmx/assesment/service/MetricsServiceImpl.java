package com.opsmx.assesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opsmx.assesment.exception.ApplicationException;
import com.opsmx.assesment.json.parser.OutputJSONParser;
import com.opsmx.assesment.model.Metric;
import com.opsmx.assesment.model.MetricsGroup;

/**
 * Implementation class of <code>MetricsService</code>
 * 
 * @author sandeep
 *
 */
@Service
public class MetricsServiceImpl implements MetricsService {
	
	@Autowired
	OutputJSONParser outputJsonParser;

	public Metric getMetric(String name) throws ApplicationException {
		
		return outputJsonParser.getMetric(name);
	}

	public MetricsGroup getMetricGroup(String name) throws ApplicationException {
		return outputJsonParser.getMetricGroup(name);
	}

}
