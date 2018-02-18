package com.stelmyit.newsbrowser.helper;

import java.util.Date;

import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.SourceFullDTO;

public class ArticleFullDtoTestFactory {
	private static final String TEST_AUTHOR = "Jan Kowalski";
	private static final String TEST_TITLE = "Test article";
	private static final String TEST_DESCRIPTION = "This is an article.";
	private static final String TEST_ARTICLE_URL = "https://sport.onet.pl/";
	private static final String TEST_IMAGE_URL = "https://ocdn.eu/sport/static/logo_sport_v1.svg";
	private static final Date TEST_DATE = new Date();
	private SourceFullDtoTestFactory sourceTestFactory;

	public ArticleFullDtoTestFactory() {
		sourceTestFactory = new SourceFullDtoTestFactory();
	}

	public ArticleFullDTO createFullDto() {
		SourceFullDTO source = sourceTestFactory.createFullDto();
		return ArticleFullDtoTestBuilder.getInstance()
				.source(source)
				.author(TEST_AUTHOR)
				.title(TEST_TITLE)
				.description(TEST_DESCRIPTION)
				.articleUrl(TEST_ARTICLE_URL)
				.imageUrl(TEST_IMAGE_URL)
				.date(TEST_DATE)
				.build();
	}
}
