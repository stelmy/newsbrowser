package com.stelmyit.newsbrowser.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Country {
  PL("pl");

  private String code;

  private Country(String code) {
    this.code = code;
  }

  @JsonValue
  public String getCode() {
    return code;
  }

  public static Country create(String name) throws NewsBrowserException {
    Country result = null;

    for (Country value : values()) {
      if (name.equals(value.getCode())) {
        result = value;
        break;
      }
    }

    if (result == null) {
      throw new NewsBrowserException("Given country is unknown.");
    }

    return result;
  }

}
