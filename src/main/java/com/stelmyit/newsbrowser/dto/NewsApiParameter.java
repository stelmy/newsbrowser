package com.stelmyit.newsbrowser.dto;

public enum NewsApiParameter {
  CATEGORY("category"), COUNTRY("country"), API_KEY("apiKey"), QUERY("q"), PAGE_SIZE("pageSize"), PAGE("page");

  private String name;

  private NewsApiParameter(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
