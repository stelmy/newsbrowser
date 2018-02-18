package com.stelmyit.newsbrowser.dto;

import java.util.ArrayList;
import java.util.List;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;

public class News {

	private Country country;
	private Category category;
	private List<Article> articles;

	private News(Builder builder) {
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

	public static class Builder {
		private Country country;
		private Category category;
		private List<Article> articles;

		private Builder() {
			this.articles = new ArrayList<>();
		}

		public static Builder getInstance() {
			return new Builder();
		}

		public Builder country(Country country) {
			this.country = country;
			return this;
		}

		public Builder category(Category category) {
			this.category = category;
			return this;
		}

		public Builder articles(List<Article> articles) {
			this.articles = articles;
			return this;
		}

		public News build() {
			return new News(this);
		}
	}
}
