package com.stelmyit.newsbrowser.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.stelmyit.newsbrowser.exception.NewsBrowserException;

@Service
public class JsonCreator {
	private static final Logger LOGGER = Logger.getLogger(JsonCreator.class.getName());

	public String create(URL url) throws NewsBrowserException {
		String json = null;

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			json = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		} catch (IOException e) {
			throw new NewsBrowserException("Connection error during JSON creation.");
		}
		return json;
	}
}
