package com.stelmyit.newsbrowser.service;

import static com.stelmyit.newsbrowser.dictionary.Category.TECHNOLOGY;
import static com.stelmyit.newsbrowser.dictionary.Country.PL;
import static com.stelmyit.newsbrowser.helper.TestUtils.getTextFromFile;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.factory.NewsFactory;
import com.stelmyit.newsbrowser.helper.NewsFullDtoTestFactory;

public class NewsServiceTest {

	private NewsService newsService;
	private NewsFactory newsFactory;
	private NewsFullDtoTestFactory newsTestFactory;
	private NewsFullDTO newsFullDTO;

	@Before
	public void before() throws NewsBrowserException {
		newsTestFactory = new NewsFullDtoTestFactory();
		newsFullDTO = newsTestFactory.createFullDto();
		initNewsFactory();
		initNewsService();
	}

	@Test
	public void shouldCreateNews() throws NewsBrowserException {
		// Given
		Category category = TECHNOLOGY;
		Country country = PL;

		// When
		newsService.getNews(country, category);

		// Then
		verify(newsFactory).create(newsFullDTO, country, category);
	}

	private void initNewsService() throws NewsBrowserException {
		newsService = new NewsService();
		setField(newsService, "newsFactory", newsFactory);

		mockNewsApiParameterFactory();
		mockNewsApiUrlGenerator();
		mockJsonCreator();
		JsonParser<NewsFullDTO> parser = mockJsonParser();
		mockJsonParserFactory(parser);
	}

	private void mockNewsApiParameterFactory() {
		NewsApiParameterFactory newsApiParameterFactory = mock(NewsApiParameterFactory.class);
		setField(newsService, "newsApiParameterFactory", newsApiParameterFactory);
		when(newsApiParameterFactory.createTopHeadlinesParameters(any(Country.class), any(Category.class)))
				.thenReturn(null);
	}

	private void mockNewsApiUrlGenerator() {
		NewsApiUrlGenerator newsApiUrlGenerator = mock(NewsApiUrlGenerator.class);
		setField(newsService, "newsApiUrlGenerator", newsApiUrlGenerator);
		when(newsApiUrlGenerator.generateTopHeadlines(anyMapOf(NewsApiParameter.class, String.class))).thenReturn(null);

	}

	private void mockJsonCreator() throws NewsBrowserException {
		JsonCreator jsonCreator = mock(JsonCreator.class);
		setField(newsService, "jsonCreator", jsonCreator);
		when(jsonCreator.create(any(URL.class))).thenReturn(getTextFromFile("news.json"));
	}

	private JsonParser<NewsFullDTO> mockJsonParser() {
		JsonParser<NewsFullDTO> jsonParser = mock(JsonParser.class);
		when(jsonParser.parse(anyString())).thenReturn(newsFullDTO);
		return jsonParser;
	}

	private void mockJsonParserFactory(JsonParser<NewsFullDTO> jsonParser) {
		JsonParserFactory<NewsFullDTO> jsonParserFactory = mock(JsonParserFactory.class);
		setField(newsService, "jsonParserFactory", jsonParserFactory);
		when(jsonParserFactory.getParser(NewsFullDTO.class)).thenReturn(jsonParser);
	}

	private void initNewsFactory() {
		newsFactory = mock(NewsFactory.class);
	}

}
