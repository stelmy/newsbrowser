package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.Category.TECHNOLOGY;
import static com.stelmyit.newsbrowser.dictionary.Country.PL;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.API_KEY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.CATEGORY;
import static com.stelmyit.newsbrowser.dto.NewsApiParameter.COUNTRY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.stelmyit.newsbrowser.dto.NewsApiParameter;

public class NewsApiUrlGeneratorTest {
  private static final String TEST_API_KEY = "TEST_API_KEY";
  private NewsApiUrlGenerator newsApiUrlGenerator;

  public NewsApiUrlGeneratorTest() {
    this.newsApiUrlGenerator = new NewsApiUrlGenerator();
  }

  @Test
  public void shouldGenerateUrl() {
    // Given
    Map<NewsApiParameter, String> parameters = new LinkedHashMap<>();
    parameters.put(CATEGORY, TECHNOLOGY.getName());
    parameters.put(COUNTRY, PL.getCode());
    parameters.put(API_KEY, TEST_API_KEY);

    // When
    URL url = newsApiUrlGenerator.generateTopHeadlines(parameters);

    // Then
    assertEquals("https://newsapi.org/v2/top-headlines?category=technology&country=pl&apiKey=TEST_API_KEY",
        url.toString());
  }

  @Test
  public void shouldNotGenerateUrl_noParameters() {
    // Given
    Map<NewsApiParameter, String> parameters = new LinkedHashMap<>();

    // When
    URL url = newsApiUrlGenerator.generateTopHeadlines(parameters);

    // Then
    assertNull(url);
  }
}
