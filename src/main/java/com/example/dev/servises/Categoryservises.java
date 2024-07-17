package com.example.dev.servises;

import java.util.List;

import com.example.dev.payload.CategoryDto;

public interface Categoryservises {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	
	
	 void deleteCategory(Integer categoryId);
	
	
	 CategoryDto getCategory(Integer  categoryId);
	 
	 
	 List<CategoryDto> getCategories();
}
