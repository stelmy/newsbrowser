package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.Category.TECHNOLOGY;
import static com.stelmyit.newsbrowser.dictionary.Country.PL;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.API_KEY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.CATEGORY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.COUNTRY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.QUERY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;

public class NewsApiParameterFactoryTest {

  private NewsApiParameterFactory newsApiParameterFactory;

  public NewsApiParameterFactoryTest() {
    newsApiParameterFactory = new NewsApiParameterFactory();
  }

  @Test
  public void shouldCreateTopHeadlinesParameters() {
    // Given
    Category category = TECHNOLOGY;
    Country country = PL;

    // When
    Map<NewsApiParameter, String> parameters = newsApiParameterFactory.createTopHeadlinesParameters(country, category);

    // Then
    assertEquals(category.getId(), parameters.get(CATEGORY));
    assertEquals(country.getCode(), parameters.get(COUNTRY));
    assertNull(parameters.get(QUERY));
    assertNotNull(parameters.get(API_KEY));
  }

  @Test
  public void shouldCreateSearchParameters() {
    // Given
    String query = "haslo";
    
    // When
    Map<NewsApiParameter, String> parameters = newsApiParameterFactory.createSearchParameters(query);

    // Then
    assertEquals(query, parameters.get(QUERY));
    assertNull(parameters.get(CATEGORY));
    assertNull(parameters.get(COUNTRY));
    assertNotNull(parameters.get(API_KEY));
  }
}
