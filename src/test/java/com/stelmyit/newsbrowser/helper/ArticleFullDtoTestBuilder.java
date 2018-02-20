package com.stelmyit.newsbrowser.helper;

import java.util.Date;

import org.springframework.test.util.ReflectionTestUtils;

import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.SourceFullDTO;

public class ArticleFullDtoTestBuilder {

  private ArticleFullDTO article;

  private ArticleFullDtoTestBuilder() {
    article = new ArticleFullDTO();
  }

  public static ArticleFullDtoTestBuilder getInstance() {
    return new ArticleFullDtoTestBuilder();
  }

  public ArticleFullDTO build() {
    return article;
  }

  public ArticleFullDtoTestBuilder source(SourceFullDTO source) {
    ReflectionTestUtils.setField(article, "source", source);
    return this;
  }

  public ArticleFullDtoTestBuilder author(String author) {
    ReflectionTestUtils.setField(article, "author", author);
    return this;
  }

  public ArticleFullDtoTestBuilder title(String title) {
    ReflectionTestUtils.setField(article, "title", title);
    return this;
  }

  public ArticleFullDtoTestBuilder description(String description) {
    ReflectionTestUtils.setField(article, "description", description);
    return this;
  }

  public ArticleFullDtoTestBuilder articleUrl(String articleUrl) {
    ReflectionTestUtils.setField(article, "articleUrl", articleUrl);
    return this;
  }

  public ArticleFullDtoTestBuilder imageUrl(String imageUrl) {
    ReflectionTestUtils.setField(article, "imageUrl", imageUrl);
    return this;
  }

  public ArticleFullDtoTestBuilder date(Date date) {
    ReflectionTestUtils.setField(article, "date", date);
    return this;
  }

}
