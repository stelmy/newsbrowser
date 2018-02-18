package com.stelmyit.newsbrowser.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser<T> {
	private static final Logger LOGGER = Logger.getLogger(JsonParser.class.getName());

	final Class<T> clazz;

	public JsonParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T parse(String json) {
		T object = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			object = mapper.readValue(json, clazz);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Cannot parse JSON.", e);
		}

		return object;

	}

}
