package com.stelmyit.newsbrowser.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stelmyit.newsbrowser.dictionary.Category;
import com.stelmyit.newsbrowser.dto.CategoryDTO;
import com.stelmyit.newsbrowser.exception.NewsBrowserRuntimeException;

@Component
public class CategoryFactory {

  public List<CategoryDTO> createAllDTOs() {
    List<Category> allCategories = Arrays.asList(Category.values());
    validate(allCategories);
    return allCategories.stream().map(category -> createDTO(category)).collect(Collectors.toList());
  }

  private CategoryDTO createDTO(Category category) {
    return CategoryDTO.Builder.getInstance()
        .name(category.getName())
        .id(category.getId())
        .isDefault(category.isDefault())
        .build();
  }

  private void validate(List<Category> categories) {
    List<Category> allDefaultCategories = categories.stream().filter(category -> category.isDefault())
        .collect(Collectors.toList());

    if (allDefaultCategories.size() == 0) {
      throw new NewsBrowserRuntimeException("No default category defined.");
    }
    
    if (allDefaultCategories.size() > 1) {
      throw new NewsBrowserRuntimeException("There must be only one default category.");
    }
  }
}
