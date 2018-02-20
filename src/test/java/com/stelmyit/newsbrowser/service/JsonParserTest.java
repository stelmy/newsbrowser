package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.NewsStatus.OK;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.helper.TestUtils;

public class JsonParserTest {

  @Test
  public void shouldReceiveParsedObject() {
    // Given
    JsonParser<NewsFullDTO> parser = new JsonParser<>(NewsFullDTO.class);
    String json = TestUtils.getTextFromFile("news.json");

    // When
    NewsFullDTO news = parser.parse(json);

    // Then
    assertTrue(OK.equals(news.getStatus()));
  }

}
