package com.opsmx.assesment.json.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsmx.assesment.exception.ApplicationException;
import com.opsmx.assesment.model.Container;
import com.opsmx.assesment.model.Metric;
import com.opsmx.assesment.model.MetricsGroup;

/**
 * Utility class to read the output json file located under path specified using
 * the property location and serves the response by parsing the output json
 * 
 * @author sandeep
 *
 */
@Component
public class OutputJSONParser {

	@Value("${output.file.location}")
	private String location;

	private File data = null;

	/**
	 * Load the file after bean is initialized.
	 */
	@PostConstruct
	public void loadOutputJSON() {
		data = new File(location);
	}

	/**
	 * Returns the metric details given a metric name
	 * 
	 * @param name
	 * @return
	 * @throws ApplicationException
	 */
	public Metric getMetric(String name) throws ApplicationException {
		Metric result = null;
		try {
			Container outputContainer = new ObjectMapper().readValue(data, Container.class);
			List<MetricsGroup> mGroupList = outputContainer.getCanary_output().getResults();
			for (MetricsGroup group : mGroupList) {
				result = group.getMetricList().stream().filter(p -> p.getMetricName().equals(name)).findFirst()
						.orElse(null);
				if (result != null)
					break;
			}

		} catch (JsonParseException e) {
			throw new ApplicationException("Error while parsing output JSON");
		} catch (JsonMappingException e) {
			throw new ApplicationException("Error while parsing output JSON");
		} catch (IOException e) {
			throw new ApplicationException("Error while reading output JSON");
		}

		return result;
	}

	/**
	 * Returns the metric group details given a metric name
	 * 
	 * @param name
	 * @return
	 * @throws ApplicationException
	 */
	public MetricsGroup getMetricGroup(String name) throws ApplicationException {
		Optional<MetricsGroup> result = null;
		try {
			Container outputContainer = new ObjectMapper().readValue(data, Container.class);
			result = outputContainer.getCanary_output().getResults().stream().filter(g -> g.getName().equals(name))
					.findFirst();

			if (result.isPresent()) {
				long failedMetrics = result.get().getMetricList().stream().filter(p -> p.getMetricColor().equals("red"))
						.count();
				result.get().setFailedMetrics(failedMetrics);
			}

		} catch (JsonParseException e) {
			throw new ApplicationException("Error while parsing output JSON");
		} catch (JsonMappingException e) {
			throw new ApplicationException("Error while parsing output JSON");
		} catch (IOException e) {
			throw new ApplicationException("Error while reading output JSON");
		}
		return result.get();
	}

}
