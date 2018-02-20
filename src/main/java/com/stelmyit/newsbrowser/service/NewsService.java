package com.stelmyit.newsbrowser.service;

import java.net.URL;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.factory.NewsFactory;

@Service
public class NewsService {

  @Autowired
  private JsonParserFactory<NewsFullDTO> jsonParserFactory;

  @Autowired
  private JsonCreator jsonCreator;

  @Autowired
  private NewsFactory newsFactory;

  @Autowired
  private NewsApiUrlGenerator newsApiUrlGenerator;

  @Autowired
  private NewsApiParameterFactory newsApiParameterFactory;

  public News getNews(Country country, Category category) throws NewsBrowserException {
    Map<NewsApiParameter, String> parameters = newsApiParameterFactory.createTopHeadlinesParameters(country, category);
    URL url = newsApiUrlGenerator.generateTopHeadlines(parameters);
    String json = jsonCreator.create(url);
    JsonParser<NewsFullDTO> jsonParser = jsonParserFactory.getParser(NewsFullDTO.class);
    NewsFullDTO newsDto = jsonParser.parse(json);
    return newsFactory.create(newsDto, country, category);
  }

}
