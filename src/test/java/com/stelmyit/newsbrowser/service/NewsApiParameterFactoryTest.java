package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.Category.TECHNOLOGY;
import static com.stelmyit.newsbrowser.dictionary.Country.PL;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.API_KEY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.CATEGORY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.COUNTRY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    assertEquals(TECHNOLOGY.getName(), parameters.get(CATEGORY));
    assertEquals(PL.getCode(), parameters.get(COUNTRY));
    assertNotNull(parameters.get(API_KEY));

  }
}
