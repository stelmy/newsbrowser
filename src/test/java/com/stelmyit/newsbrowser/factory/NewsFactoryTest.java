package com.stelmyit.newsbrowser.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.helper.NewsFullDtoTestFactory;

@RunWith(MockitoJUnitRunner.class)
public class NewsFactoryTest {
  private NewsFullDtoTestFactory newsTestFactory;

  @InjectMocks
  private NewsFactory newsFactory;

  @Mock
  private ArticleFactory articleFactory;

  @Before
  public void before() {
    newsTestFactory = new NewsFullDtoTestFactory();
    Mockito.when(articleFactory.create(Mockito.anyListOf(ArticleFullDTO.class))).thenCallRealMethod();
  }

  @Test
  public void shouldCreateNews() {
    // Given
    NewsFullDTO dto = newsTestFactory.createFullDto();
    Category category = Category.TECHNOLOGY;
    Country country = Country.PL;

    // When
    News news = newsFactory.create(dto, country, category);

    // Then
    assertEquals(category, news.getCategory());
    assertEquals(country, news.getCountry());
    assertTrue(news.getArticles().size() > 0);
  }

}
