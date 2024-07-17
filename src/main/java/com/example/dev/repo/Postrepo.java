package com.example.dev.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entites.Category;
import com.example.dev.entites.Post;
import com.example.dev.entites.User;

public interface Postrepo extends JpaRepository<Post, Integer>{

	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
		
	
}
