package com.example.dev.servises.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.controller.UserController;
import com.example.dev.entites.Category;
import com.example.dev.exeption.ResourceNotFoundExeption;
import com.example.dev.payload.CategoryDto;
import com.example.dev.repo.Categoryrepo;
import com.example.dev.servises.Categoryservises;

@Service
public class CategoryServiseimpl implements Categoryservises{
	
	private static final Logger logger = Logger.getLogger(CategoryServiseimpl.class.getName());
	
	@Autowired
	private Categoryrepo categoryrepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addCat=this.categoryrepo.save(cat);
		
		return this.modelMapper.map(addCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		
		Category cat = this.categoryrepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundExeption("Category","Category id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updateCategory=this.categoryrepo.save(cat);
		
		
		
		
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
           Category  cat = this.categoryrepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundExeption("Category", "category id", categoryId));
		
		this.categoryrepo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
	
		Category cat = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundExeption("Category", "category id", categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		  List<Category> categories= this.categoryrepo.findAll();
		  List<CategoryDto>  catDto=  categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDto;
		
		
	}

}
