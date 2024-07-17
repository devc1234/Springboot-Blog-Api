package com.example.dev.servises;

import java.util.List;

import com.example.dev.entites.Post;
import com.example.dev.payload.PostDto;

public interface PostServises {
	
	PostDto createPost(PostDto postDto,Integer usrId,Integer categoryId);
	
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	
	void deletePost(Integer postId);
	
	
	List<PostDto> getAllPost();
	
	
	PostDto getPostById(Integer postId);
	
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<Post> serachPost(String keyword);
	
}
