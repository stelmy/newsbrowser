package com.stelmyit.newsbrowser.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.stelmyit.newsbrowser.exception.NewsBrowserException;

public class JsonCreatorTest {

	private JsonCreator jsonCreator;

	@Before
	public void before() {
		jsonCreator = new JsonCreator();
	}

	@Test
	public void shouldGetJson() throws MalformedURLException, NewsBrowserException {
		// Given
		URL url = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=1740f93e6fdf4e80a3c654514e5704ee");

		// When
		String json = jsonCreator.create(url);

		// Then
		Assert.assertTrue(json.length() > 0);
		Assert.assertEquals('{', json.charAt(0));
		Assert.assertEquals('}', json.charAt(json.length() - 1));
	}

	@Test(expected = NewsBrowserException.class)
	public void shouldNotGetJson_invalidUrl() throws MalformedURLException, NewsBrowserException {
		// Given
		URL url = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=X");

		// When
		jsonCreator.create(url);

		// Then should throw an exception
	}
}
