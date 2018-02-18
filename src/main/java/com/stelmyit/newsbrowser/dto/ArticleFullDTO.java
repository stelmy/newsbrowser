package com.stelmyit.newsbrowser.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleFullDTO {

	@JsonProperty
	private SourceFullDTO source;

	@JsonProperty
	private String author;

	@JsonProperty
	private String title;

	@JsonProperty
	private String description;

	@JsonProperty("url")
	private String articleUrl;

	@JsonProperty("urlToImage")
	private String imageUrl;

	@JsonProperty("publishedAt")
	private Date date;

	public SourceFullDTO getSource() {
		return source;
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

	public String getArticleUrl() {
		return articleUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Date getDate() {
		return date;
	}

}
