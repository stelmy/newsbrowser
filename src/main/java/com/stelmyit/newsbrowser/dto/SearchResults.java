package com.stelmyit.newsbrowser.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchResults {

  private int totalPages;
  private List<Article> articles;

  private SearchResults(Builder builder) {
    this.totalPages = builder.totalPages;
    this.articles = builder.articles;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public static class Builder {
    private int totalPages;
    private List<Article> articles;

    private Builder() {
      this.articles = new ArrayList<>();
    }

    public static Builder getInstance() {
      return new Builder();
    }

    public Builder totalPages(int totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public Builder articles(List<Article> articles) {
      this.articles = articles;
      return this;
    }

    public SearchResults build() {
      return new SearchResults(this);
    }
  }
}
