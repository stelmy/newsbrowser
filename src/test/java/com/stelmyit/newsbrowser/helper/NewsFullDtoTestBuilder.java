package com.stelmyit.newsbrowser.helper;

import java.util.List;

import org.springframework.test.util.ReflectionTestUtils;

import com.stelmyit.newsbrowser.dictionary.NewsStatus;
import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;

public class NewsFullDtoTestBuilder {

  private NewsFullDTO news;

  private NewsFullDtoTestBuilder() {
    news = new NewsFullDTO();
  }

  public static NewsFullDtoTestBuilder getInstance() {
    return new NewsFullDtoTestBuilder();
  }

  public NewsFullDTO build() {
    return news;
  }

  public NewsFullDtoTestBuilder status(NewsStatus status) {
    ReflectionTestUtils.setField(news, "status", status);
    return this;
  }

  public NewsFullDtoTestBuilder totalResults(int totalResults) {
    ReflectionTestUtils.setField(news, "totalResults", totalResults);
    return this;
  }

  public NewsFullDtoTestBuilder articles(List<ArticleFullDTO> articles) {
    ReflectionTestUtils.setField(news, "articles", articles);
    return this;
  }
}
