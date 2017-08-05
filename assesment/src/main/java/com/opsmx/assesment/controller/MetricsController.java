package com.opsmx.assesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opsmx.assesment.exception.ApplicationException;
import com.opsmx.assesment.model.Metric;
import com.opsmx.assesment.model.MetricsGroup;
import com.opsmx.assesment.service.MetricsService;

/**
 * Controller handles the requests for metrics resource
 * 
 * @author sandeep
 *
 */
@RestController
@RequestMapping("/metrics")
public class MetricsController {

	@Autowired
	MetricsService metricsService;

	/***********************************************************************
	 * Endpoint methods
	 ***********************************************************************/

	/**
	 * Endpoint method to return metric details based on the metric name
	 * 
	 * @param metricName
	 *            the metric name
	 * @return the details of the metric
	 * @throws ApplicationException
	 */
	@RequestMapping("/metric/{metricName:.+}")
	public ResponseEntity<Metric> getMetricData(@PathVariable("metricName") String metricName)
			throws ApplicationException {
		Metric metricDetail;
		try {
			metricDetail = metricsService.getMetric(metricName);
		} catch (ApplicationException e) {
			throw new ApplicationException("Error while retrieving the metric Detail", e.getCause());
		}
		return new ResponseEntity<Metric>(metricDetail, HttpStatus.OK);
	}

	/**
	 * Endpoint method to return metric group details based on the group name
	 * 
	 * @param groupName
	 *            the metric name
	 * @return the details of the metric group
	 * @throws ApplicationException
	 */
	@RequestMapping("/metricgroup/{groupName}")
	public ResponseEntity<MetricsGroup> getMetricGroupData(@PathVariable("groupName") String groupName)
			throws ApplicationException {
		MetricsGroup metricDetail;
		try {
			metricDetail = metricsService.getMetricGroup(groupName);
		} catch (ApplicationException e) {
			throw new ApplicationException("Error while retrieving the metric group Detail", e.getCause());
		}
		return new ResponseEntity<MetricsGroup>(metricDetail, HttpStatus.OK);
	}

}
