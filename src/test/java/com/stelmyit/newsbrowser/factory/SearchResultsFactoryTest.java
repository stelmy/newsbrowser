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

import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.dto.SearchResults;
import com.stelmyit.newsbrowser.helper.NewsFullDtoTestFactory;

@RunWith(MockitoJUnitRunner.class)
public class SearchResultsFactoryTest {
  private NewsFullDtoTestFactory newsTestFactory;

  @InjectMocks
  private SearchResultsFactory searchResultsFactory;

  @Mock
  private ArticleFactory articleFactory;

  @Before
  public void before() {
    newsTestFactory = new NewsFullDtoTestFactory();
    Mockito.when(articleFactory.create(Mockito.anyListOf(ArticleFullDTO.class))).thenCallRealMethod();
  }

  @Test
  public void shouldCreateSearchResults() {
    // Given
    NewsFullDTO dto = newsTestFactory.createFullDto();

    // When
    SearchResults searchResults = searchResultsFactory.create(dto);

    // Then
    assertTrue(searchResults.getArticles().size() > 0);
  }

  @Test
  public void shouldCreateSearchResults_twoFullPages() {
    // Given
    NewsFullDTO dto = newsTestFactory.createFullDtoWithTotalResults(20);

    // When
    SearchResults searchResults = searchResultsFactory.create(dto);

    // Then
    assertEquals(2, searchResults.getTotalPages());
  }

  @Test
  public void shouldCreateSearchResults_overTwoPages() {
    // Given
    NewsFullDTO dto = newsTestFactory.createFullDtoWithTotalResults(21);

    // When
    SearchResults searchResults = searchResultsFactory.create(dto);

    // Then
    assertEquals(3, searchResults.getTotalPages());
  }
}
