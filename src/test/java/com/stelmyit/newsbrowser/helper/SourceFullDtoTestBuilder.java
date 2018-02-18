package com.stelmyit.newsbrowser.helper;

import org.springframework.test.util.ReflectionTestUtils;

import com.stelmyit.newsbrowser.dto.SourceFullDTO;

public class SourceFullDtoTestBuilder {

	private SourceFullDTO source;

	private SourceFullDtoTestBuilder() {
		source = new SourceFullDTO();
	}

	public static SourceFullDtoTestBuilder getInstance() {
		return new SourceFullDtoTestBuilder();
	}

	public SourceFullDTO build() {
		return source;
	}

	public SourceFullDtoTestBuilder sourceName(String sourceName) {
		ReflectionTestUtils.setField(source, "name", sourceName);
		return this;
	}
}
