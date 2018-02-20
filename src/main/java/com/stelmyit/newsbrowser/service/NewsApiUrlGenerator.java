package com.stelmyit.newsbrowser.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.stelmyit.newsbrowser.dto.NewsApiParameter;

@Component
public class NewsApiUrlGenerator {
  private static final Logger LOGGER = Logger.getLogger(NewsApiUrlGenerator.class.getName());

  public URL generateTopHeadlines(Map<NewsApiParameter, String> parameters) {
    URL url = null;
    try {
      if (CollectionUtils.isEmpty(parameters)) {
        return null;
      }

      List<String> parameterValues = new ArrayList<>();
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
