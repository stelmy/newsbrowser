package com.stelmyit.newsbrowser.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.factory.NewsFactory;

@Service
public class NewsService {
	private static final Logger LOGGER = Logger.getLogger(NewsService.class.getName());
	private static final String API_KEY = "1740f93e6fdf4e80a3c654514e5704ee";

	@Autowired
	private JsonParserFactory<NewsFullDTO> jsonParserFactory;

	@Autowired
	private JsonCreator jsonCreator;

	@Autowired
	private NewsFactory newsFactory;

	public News getNews(Country country, Category category) {
		News news = null;

		try {
			URL url = getUrl(country, category);
			String json = jsonCreator.create(url);
			JsonParser<NewsFullDTO> jsonParser = jsonParserFactory.getParser(NewsFullDTO.class);
			NewsFullDTO newsDto = jsonParser.parse(json);
			news = newsFactory.create(newsDto, country, category);
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, "Cannot get URL from News API", e);
		}

		return news;

	}

	private URL getUrl(Country country, Category category) throws MalformedURLException {
		String url = String.format("https://newsapi.org/v2/top-headlines?category=%s&country=%s&apiKey=%s",
				category.getName(), country.getCode(), API_KEY);
		return new URL(url);
	}
}
