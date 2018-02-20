package com.stelmyit.newsbrowser.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stelmyit.newsbrowser.dictionary.NewsStatus;

public class NewsFullDTO {

  @JsonProperty
  private NewsStatus status;

  @JsonProperty
  private int totalResults;

  @JsonProperty
  private List<ArticleFullDTO> articles;

  public NewsStatus getStatus() {
    return status;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public List<ArticleFullDTO> getArticles() {
    return articles;
  }

}
