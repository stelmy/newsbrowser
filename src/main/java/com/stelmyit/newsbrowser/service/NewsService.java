package com.stelmyit.newsbrowser.service;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
import com.stelmyit.newsbrowser.dictionary.UrlHeader;
import com.stelmyit.newsbrowser.dto.Article;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.dto.NewsApiParameter;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.factory.ArticleFactory;
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
  private ArticleFactory articleFactory;

  @Autowired
  private NewsApiUrlGenerator newsApiUrlGenerator;

  @Autowired
  private NewsApiParameterFactory newsApiParameterFactory;

  public News getTopNews(String countryCode, String categoryId) throws NewsBrowserException {
    Country country = Country.create(countryCode);
    Category category = Category.create(categoryId);
    Map<NewsApiParameter, String> parameters = newsApiParameterFactory.createTopHeadlinesParameters(country, category);
    URL url = newsApiUrlGenerator.generateUrl(UrlHeader.TOP_HEADLINES, parameters);
    String json = jsonCreator.create(url);
    JsonParser<NewsFullDTO> jsonParser = jsonParserFactory.getParser(NewsFullDTO.class);
    NewsFullDTO newsDto = jsonParser.parse(json);
    return newsFactory.create(newsDto, country, category);
  }

  public List<Article> search(String query) throws NewsBrowserException {
    Map<NewsApiParameter, String> parameters = newsApiParameterFactory.createSearchParameters(query);
    URL url = newsApiUrlGenerator.generateUrl(UrlHeader.EVERYTHING, parameters);
    String json = jsonCreator.create(url);
    JsonParser<NewsFullDTO> jsonParser = jsonParserFactory.getParser(NewsFullDTO.class);
    NewsFullDTO newsDto = jsonParser.parse(json);
    return articleFactory.create(newsDto.getArticles());
  }

}
