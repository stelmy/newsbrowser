package com.stelmyit.newsbrowser.factory;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.stelmyit.newsbrowser.dto.Article;
import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.factory.ArticleFactory;
import com.stelmyit.newsbrowser.helper.ArticleFullDtoTestFactory;

public class ArticleFactoryTest {

  private ArticleFactory articleFactory;
  private ArticleFullDtoTestFactory articleTestFactory;

  @Before
  public void before() {
    articleFactory = new ArticleFactory();
    articleTestFactory = new ArticleFullDtoTestFactory();
  }

  @Test
  public void shouldCreateArticle() {
    // Given
    ArticleFullDTO articleDto = articleTestFactory.createFullDto();

    // When
    List<Article> articles = articleFactory.create(Arrays.asList(articleDto));

    // Then
    Article article = articles.get(0);
    assertEquals(article.getAuthor(), articleDto.getAuthor());
    assertEquals(article.getTitle(), articleDto.getTitle());
    assertEquals(article.getArticleUrl(), articleDto.getArticleUrl());
    assertEquals(article.getDescription(), articleDto.getDescription());
    assertEquals(article.getImageUrl(), articleDto.getImageUrl());
    assertEquals(article.getDate(), articleDto.getDate());
    assertEquals(article.getSourceName(), articleDto.getSource().getName());
  }

}
