package com.stelmyit.newsbrowser.helper;

import com.stelmyit.newsbrowser.dto.SourceFullDTO;

public class SourceFullDtoTestFactory {
	private static final String TEST_NAME = "Test source";

	public SourceFullDTO createFullDto() {
		return SourceFullDtoTestBuilder.getInstance().sourceName(TEST_NAME).build();
	}
}
