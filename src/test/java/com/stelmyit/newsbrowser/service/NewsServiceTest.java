package com.stelmyit.newsbrowser.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.factory.ArticleFactory;
import com.stelmyit.newsbrowser.factory.NewsFactory;
import com.stelmyit.newsbrowser.helper.TestUtils;

public class NewsServiceTest {

	private NewsService newsService;

	@Before
	public void before() throws NewsBrowserException {
		newsService = new NewsService();
		initMocks();
	}

	@Test
	public void shouldCreateNews() throws NewsBrowserException {
		// Given
		Category category = Category.TECHNOLOGY;
		Country country = Country.PL;

		// When
		News news = newsService.getNews(country, category);

		// Then
		assertEquals(category, news.getCategory());
		assertEquals(country, news.getCountry());
		assertTrue(news.getArticles().size() > 0);
	}
	
	private void initMocks() throws NewsBrowserException {
		JsonCreator jsonCreator = Mockito.mock(JsonCreator.class);
		JsonParserFactory<NewsFullDTO> jsonParserFactory = new JsonParserFactory<>();
		NewsFactory newsFactory = new NewsFactory();
		ArticleFactory articleFactory = new ArticleFactory();

		String json = TestUtils.getTextFromFile("news.json");
		Mockito.when(jsonCreator.create(Mockito.any(URL.class))).thenReturn(json);
		
		ReflectionTestUtils.setField(newsService, "jsonCreator", jsonCreator);
		ReflectionTestUtils.setField(newsService, "jsonParserFactory", jsonParserFactory);
		ReflectionTestUtils.setField(newsService, "newsFactory", newsFactory);
		ReflectionTestUtils.setField(newsFactory, "articleFactory", articleFactory);
	}
}
