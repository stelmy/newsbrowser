package com.stelmyit.newsbrowser.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Country {
	PL("pl");

	// TODO: all available countries
	// ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp
	// kr lt lv ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us
	// ve za

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
