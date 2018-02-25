package com.stelmyit.newsbrowser.dictionary;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Category {
  BUSINESS("business", "Biznes", false), ENTERTAINMENT("entertainment", "Rozrywka", false), GENERAL("general", "Ogólne",
      false), HEALTH("health", "Zdrowie", false), SCIENCE("science", "Nauka",
          false), SPORTS("sports", "Sport", false), TECHNOLOGY("technology", "Technologia", true);

  private String id;
  private String name;
  private boolean isDefault;

  private Category(String id, String name, boolean isDefault) {
    this.id = id;
    this.name = name;
    this.isDefault = isDefault;
  }

  @JsonValue
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public static Category create(String id) throws NewsBrowserException {
    Category result = null;

    for (Category value : values()) {
      if (Objects.equals(id, value.getId())) {
        result = value;
        break;
      }
    }

    if (result == null) {
      throw new NewsBrowserException(String.format("Given category: %s is unknown.", id));
    }

    return result;
  }

}
