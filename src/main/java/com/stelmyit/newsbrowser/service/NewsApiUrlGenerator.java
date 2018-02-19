package com.stelmyit.newsbrowser.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.stelmyit.newsbrowser.dto.NewsApiParameter;

@Component
public class NewsApiUrlGenerator {
	private static final Logger LOGGER = Logger.getLogger(NewsApiUrlGenerator.class.getName());

	public URL generateTopHeadlines(Map<NewsApiParameter, String> parameters) {
		URL url = null;
		try {
			Set<String> parameterValues = new HashSet<>();
			for (Entry<NewsApiParameter, String> entry : parameters.entrySet()) {
				String name = entry.getKey().getName();
				String value = entry.getValue();
				parameterValues.add(String.format("%s=%s", name, value));
			}

			String parametersJoined = String.join("&", parameterValues);

			url = new URL(String.format("https://newsapi.org/v2/top-headlines?%s", parametersJoined));
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, "Cannot receive URL.", e);
		}

		return url;

	}
}
