package com.stelmyit.newsbrowser.helper;

import java.util.Arrays;

import com.stelmyit.newsbrowser.dictionary.NewsStatus;
import com.stelmyit.newsbrowser.dto.ArticleFullDTO;
import com.stelmyit.newsbrowser.dto.NewsFullDTO;

public class NewsFullDtoTestFactory {
  private static final NewsStatus TEST_STATUS = NewsStatus.OK;
  private static final int TEST_TOTAL_RESULTS = 20;
  private ArticleFullDtoTestFactory articleTestFactory;

  public NewsFullDtoTestFactory() {
    articleTestFactory = new ArticleFullDtoTestFactory();
  }

  public NewsFullDTO createFullDto() {
    return createFullDtoWithTotalResults(TEST_TOTAL_RESULTS);
  }
  
  public NewsFullDTO createFullDtoWithTotalResults(int totalResults) {
    ArticleFullDTO articleDto = articleTestFactory.createFullDto();
    return NewsFullDtoTestBuilder.getInstance()
        .status(TEST_STATUS)
        .totalResults(totalResults)
        .articles(Arrays.asList(articleDto))
        .build();
  }

}
