package com.stelmyit.newsbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stelmyit.newsbrowser.annotations.Controller;
import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dictionary.Country;
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
    Country country = Country.create(countryCode);
    Category category = Category.create(categoryId);
    return newsService.getNews(country, category);
  }

}
