package com.stelmyit.newsbrowser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stelmyit.newsbrowser.annotations.Controller;
import com.stelmyit.newsbrowser.dto.CategoryDTO;
import com.stelmyit.newsbrowser.factory.CategoryFactory;

@Controller
public class DictionaryController {

  @Autowired
  private CategoryFactory categoryFactory;

  @RequestMapping(value = "dictionary/category", method = RequestMethod.GET)
  public List<CategoryDTO> getCategoryDTOs() {
    return categoryFactory.createAllDTOs();
  }
}
