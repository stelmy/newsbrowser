package com.stelmyit.newsbrowser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {

  @JsonProperty
  private String id;

  @JsonProperty
  private String name;

  @JsonProperty
  private boolean isDefault;

  private CategoryDTO(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.isDefault = builder.isDefault;
  }

  public static class Builder {
    private String id;
    private String name;
    private boolean isDefault;
    
    public static Builder getInstance() {
      return new Builder();
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder isDefault(boolean isDefault) {
      this.isDefault = isDefault;
      return this;
    }

    public CategoryDTO build() {
      return new CategoryDTO(this);
    }
  }
}
