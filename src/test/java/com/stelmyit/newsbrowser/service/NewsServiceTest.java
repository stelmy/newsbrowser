package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.Category.TECHNOLOGY;
import static com.stelmyit.newsbrowser.dictionary.Country.PL;
import static com.stelmyit.newsbrowser.helper.TestUtils.getTextFromFile;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dictionary.UrlHeader;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.factory.ArticleFactory;
import com.stelmyit.newsbrowser.factory.NewsFactory;
import com.stelmyit.newsbrowser.factory.SearchResultsFactory;
import com.stelmyit.newsbrowser.helper.NewsFullDtoTestFactory;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {

  @InjectMocks
  private NewsService newsService;

  @Mock
  private NewsFactory newsFactory;

  @Mock
  private NewsFullDtoTestFactory newsTestFactory;

  @Mock
  private NewsFullDTO newsFullDTO;

  @Mock
  private NewsApiParameterFactory newsApiParameterFactory;

  @Mock
  private NewsApiUrlGenerator newsApiUrlGenerator;

  @Mock
  private JsonCreator jsonCreator;

  @Mock
  private JsonParser<NewsFullDTO> jsonParser;

  @Mock
  private JsonParserFactory<NewsFullDTO> jsonParserFactory;

  @Mock
  private ArticleFactory articleFactory;

  @Mock
  private SearchResultsFactory searchResultFactory;

  @Before
  public void before() throws NewsBrowserException {
    when(newsApiParameterFactory.createTopHeadlinesParameters(any(Country.class), any(Category.class)))
        .thenReturn(null);
    when(newsApiUrlGenerator.generateUrl(any(UrlHeader.class), anyMapOf(NewsApiParameter.class, String.class)))
        .thenReturn(null);
    when(jsonCreator.create(any(URL.class))).thenReturn(getTextFromFile("news.json"));
    when(jsonParser.parse(anyString())).thenReturn(newsFullDTO);
    when(jsonParserFactory.getParser(NewsFullDTO.class)).thenReturn(jsonParser);
  }

  @Test
  public void shouldGetTopNews() throws NewsBrowserException {
    // Given
    Category category = TECHNOLOGY;
    Country country = PL;

    // When
    newsService.getTopNews(country.getCode(), category.getId());

    // Then
    verify(newsFactory).create(newsFullDTO, country, category);
  }

  @Test
  public void shouldSearchNews() throws NewsBrowserException {
    // Given
    String query = "test";

    // When
    newsService.search(query, 1);

    // Then
    verify(searchResultFactory).create(newsFullDTO);
  }

}
