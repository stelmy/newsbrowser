package com.stelmyit.newsbrowser.controllers.news;

import java.util.Date;

public class Article {

	private String author;
	private String title;
	private String description;
	// TODO: replace with custom Day class
	private Date date;
	private String sourceName;
	private String articleUrl;
	private String imageUrl;

	private Article(ArticleBuilder builder) {
		this.author = builder.author;
		this.title = builder.title;
		this.description = builder.description;
		this.date = builder.date;
		this.sourceName = builder.sourceName;
		this.articleUrl = builder.articleUrl;
		this.imageUrl = builder.imageUrl;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public static class ArticleBuilder {
		private String author;
		private String title;
		private String description;
		// TODO: replace with custom Day class
		private Date date;
		private String sourceName;
		private String articleUrl;
		private String imageUrl;

		public ArticleBuilder() {
			// default constructor
		}

		public ArticleBuilder author(String author) {
			this.author = author;
			return this;
		}

		public ArticleBuilder title(String title) {
			this.title = title;
			return this;
		}

		public ArticleBuilder description(String description) {
			this.description = description;
			return this;
		}

		public ArticleBuilder date(Date date) {
			this.date = date;
			return this;
		}

		public ArticleBuilder sourceName(String sourceName) {
			this.sourceName = sourceName;
			return this;
		}

		public ArticleBuilder articleUrl(String articleUrl) {
			this.articleUrl = articleUrl;
			return this;
		}

		public ArticleBuilder imageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public Article build() {
			return new Article(this);
		}
	}
}
