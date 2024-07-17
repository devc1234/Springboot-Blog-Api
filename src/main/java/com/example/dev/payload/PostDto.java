package com.example.dev.payload;

import java.util.Date;

import com.example.dev.entites.Category;
import com.example.dev.entites.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	
	private Integer postId;
	
	private String title;
	
	
	private String Content;
	
	private String imageName;
	
	
	private Date addDate;
	
	
	

	private CategoryDto category;
	
	
	
	private UserDto user;
	

}
