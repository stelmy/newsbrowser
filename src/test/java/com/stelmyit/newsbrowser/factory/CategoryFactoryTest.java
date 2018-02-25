package com.stelmyit.newsbrowser.factory;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dto.CategoryDTO;

public class CategoryFactoryTest {
  
  private CategoryFactory categoryFactory;
  
  @Before
  public void before() {
    categoryFactory = new CategoryFactory();
  }

  @Test
  public void test() {
    // Given
    int categoriesCount = Category.values().length;
    
    // When
    List<CategoryDTO> foundCategories = categoryFactory.createAllDTOs();
    
    // Then
    Assert.assertEquals(categoriesCount, foundCategories.size());
  }
}
