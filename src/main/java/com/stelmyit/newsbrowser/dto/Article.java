package com.stelmyit.newsbrowser.dto;

import java.util.Date;

public class Article {

  private String author;
  private String title;
  private String description;
  private Date date;
  private String sourceName;
  private String articleUrl;
  private String imageUrl;

  private Article(Builder builder) {
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

  public static class Builder {
    private String author;
    private String title;
    private String description;
    private Date date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    private Builder() {
      // default constructor
    }

    public static Builder getInstance() {
      return new Builder();
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder date(Date date) {
      this.date = date;
      return this;
    }

    public Builder sourceName(String sourceName) {
      this.sourceName = sourceName;
      return this;
    }

    public Builder articleUrl(String articleUrl) {
      this.articleUrl = articleUrl;
      return this;
    }

    public Builder imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public Article build() {
      return new Article(this);
    }
  }
}
