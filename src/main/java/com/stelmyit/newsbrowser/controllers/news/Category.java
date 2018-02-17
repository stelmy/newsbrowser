package com.stelmyit.newsbrowser.controllers.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

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

}
