package com.stelmyit.newsbrowser.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.stelmyit.newsbrowser.common.Constants;
import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;

@Component
public class NewsApiParameterFactory {
  private static final String API_KEY = "1740f93e6fdf4e80a3c654514e5704ee";

  public Map<NewsApiParameter, String> createTopHeadlinesParameters(Country country, Category category) {
    Map<NewsApiParameter, String> parameters = new HashMap<>();
    parameters.put(NewsApiParameter.COUNTRY, country.getCode());
    parameters.put(NewsApiParameter.CATEGORY, category.getId());
    parameters.put(NewsApiParameter.API_KEY, API_KEY);
    return parameters;
  }

  public Map<NewsApiParameter, String> createSearchParameters(String query, int page) {
    Map<NewsApiParameter, String> parameters = new HashMap<>();
    parameters.put(NewsApiParameter.QUERY, query);
    parameters.put(NewsApiParameter.PAGE_SIZE, Constants.DEFAULT_PAGE_SIZE);
    parameters.put(NewsApiParameter.PAGE, String.valueOf(page));
    parameters.put(NewsApiParameter.API_KEY, API_KEY);
    return parameters;
  }

}
