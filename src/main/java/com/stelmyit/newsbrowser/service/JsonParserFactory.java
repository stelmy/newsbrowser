package com.stelmyit.newsbrowser.service;

import org.springframework.stereotype.Component;

@Component
public class JsonParserFactory<T> {

  public JsonParser<T> getParser(Class<T> clazz) {
    return new JsonParser<>(clazz);
  }

}
