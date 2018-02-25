package com.stelmyit.newsbrowser.dictionary;

public enum UrlHeader {
  TOP_HEADLINES("top-headlines"), EVERYTHING("everything");
  
  private String name;

  public String getName() {
    return name;
  }

  private UrlHeader(String name) {
    this.name = name;
  }

}
