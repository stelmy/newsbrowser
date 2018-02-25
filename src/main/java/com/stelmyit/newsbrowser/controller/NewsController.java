package com.stelmyit.newsbrowser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stelmyit.newsbrowser.annotations.Controller;
import com.stelmyit.newsbrowser.dto.Article;
import com.stelmyit.newsbrowser.dto.News;
import com.stelmyit.newsbrowser.exception.NewsBrowserException;
import com.stelmyit.newsbrowser.service.NewsService;

@Controller
public class NewsController {

  @Autowired
  private NewsService newsService;

  @RequestMapping(value = "news/{lang}/{category}", method = RequestMethod.GET)
  public News getNews(@PathVariable("lang") String countryCode, @PathVariable("category") String categoryId)
      throws NewsBrowserException {
    return newsService.getTopNews(countryCode, categoryId);
  }

  @RequestMapping(value = "news/search/{query}", method = RequestMethod.GET)
  public List<Article> searchNews(@PathVariable("query") String query) throws NewsBrowserException {
    return newsService.search(query);
  }

}
