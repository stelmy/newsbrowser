package com.stelmyit.newsbrowser.controllers.news;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	@RequestMapping("test")
	public News test() {
		Article article = new Article.ArticleBuilder()
				.author("Jacek Placek")
				.build();
		List<Article> articles = new ArrayList<>();
		articles.add(article);
		return new News.NewsBuilder()
				.category(Category.TECHNOLOGY)
				.country(Country.PL)
				.articles(articles)
				.build();
	}
	
}
