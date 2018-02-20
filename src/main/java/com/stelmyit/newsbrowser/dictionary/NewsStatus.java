package com.stelmyit.newsbrowser.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum NewsStatus {
  OK("ok");

  private String name;

  private NewsStatus(String name) {
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return name;
  }

}
