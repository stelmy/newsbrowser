package com.stelmyit.newsbrowser.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Category {
  BUSINESS("business"),
  ENTERTAINMENT("entertainment"),
  GENERAL("general"),
  HEALTH("health"),
  SCIENCE("science"),
  SPORTS("sports"),
  TECHNOLOGY("technology");

  private String name;

  private Category(String name) {
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return name;
  }

  public static Category create(String name) throws NewsBrowserException {
    Category result = null;

    for (Category value : values()) {
      if (name.equals(value.getName())) {
        result = value;
        break;
      }
    }

    if (result == null) {
      throw new NewsBrowserException("Given category is unknown.");
    }

    return result;
  }

}
