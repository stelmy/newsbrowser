package com.stelmyit.newsbrowser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceFullDTO {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
