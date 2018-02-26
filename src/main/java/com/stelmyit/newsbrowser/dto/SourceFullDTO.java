package com.stelmyit.newsbrowser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceFullDTO {

  @JsonProperty
  private String id;

  @JsonProperty
  private String name;

  public String getName() {
    return name;
  }

}
