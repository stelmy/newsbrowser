package com.stelmyit.newsbrowser.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.helper.NewsFullDtoTestFactory;

public class NewsFactoryTest {

	private NewsFactory newsFactory;
	private NewsFullDtoTestFactory newsTestFactory;

	@Before
	public void before() {
		newsFactory = getNewsFactory();
		newsTestFactory = new NewsFullDtoTestFactory();
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

	private NewsFactory getNewsFactory() {
		newsFactory = new NewsFactory();
		ArticleFactory articleFactory = new ArticleFactory();
		ReflectionTestUtils.setField(newsFactory, "articleFactory", articleFactory);
		return newsFactory;
	}
}
