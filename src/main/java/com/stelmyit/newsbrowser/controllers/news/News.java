package com.stelmyit.newsbrowser.controllers.news;

import java.util.ArrayList;
import java.util.List;

public class News {

	private Country country;
	private Category category;
	private List<Article> articles;

	private News(NewsBuilder builder) {
		this.country = builder.country;
		this.category = builder.category;
		this.articles = builder.articles;
	}

	public Country getCountry() {
		return country;
	}

	public Category getCategory() {
		return category;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public static class NewsBuilder {
		private Country country;
		private Category category;
		private List<Article> articles;

		public NewsBuilder() {
			this.articles = new ArrayList<>();
		}

		public NewsBuilder country(Country country) {
			this.country = country;
			return this;
		}

		public NewsBuilder category(Category category) {
			this.category = category;
			return this;
		}

		public NewsBuilder articles(List<Article> articles) {
			this.articles = articles;
			return this;
		}

		public News build() {
			return new News(this);
		}
	}
}
