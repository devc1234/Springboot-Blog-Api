package com.example.dev.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.payload.ApiResponce;
import com.example.dev.payload.CategoryDto;
import com.example.dev.servises.Categoryservises;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catcon")
public class Categorycontroller {
	
	@Autowired
	private Categoryservises categoryservises;
	
	
	private static final Logger logger = Logger.getLogger(Categorycontroller.class.getName());
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto caDto){
		logger.info("post mapping implements");
		CategoryDto createCategory = this.categoryservises.createCategory(caDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid@RequestBody CategoryDto caDto,@PathVariable Integer catId){
		CategoryDto updateCategory = this.categoryservises.updateCategory(caDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
		
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponce>deleteCategory(@PathVariable Integer catId){
		 this.categoryservises.deleteCategory( catId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("category delected sussefully",true),HttpStatus.OK);
		
	}

	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer catId){
		 
		 CategoryDto caDto  =this.categoryservises.getCategory(catId);
		 
		 return new ResponseEntity<CategoryDto>(caDto,HttpStatus.OK);
		
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>getCategories(){
		 
	List<CategoryDto> categories =	this.categoryservises.getCategories();
	
	return ResponseEntity.ok(categories);
		
	}
	
}
