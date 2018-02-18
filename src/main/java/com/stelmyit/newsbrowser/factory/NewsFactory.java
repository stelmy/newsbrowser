package com.stelmyit.newsbrowser.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.Article;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;

@Component
public class NewsFactory {

	@Autowired
	private ArticleFactory articleFactory;

	public News create(NewsFullDTO dto, Country country, Category category) {
		List<Article> articles = articleFactory.create(dto.getArticles());
		return News.Builder.getInstance().category(category).country(country).articles(articles).build();
	}
}
