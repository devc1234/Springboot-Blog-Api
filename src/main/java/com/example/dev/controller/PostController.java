package com.example.dev.controller;

import java.util.List;

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
import com.example.dev.payload.PostDto;
import com.example.dev.servises.PostServises;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	PostServises postServises;

	
	@PostMapping("/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer catId){
		PostDto createPost =this.postServises.createPost(postDto, userId, catId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>>  getpostByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postServises.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
	List<PostDto>	allpost=this.postServises.getAllPost();
	return new ResponseEntity<List<PostDto>>(allpost,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer  postId){
	
		PostDto postDto = this.postServises.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponce deletePost(@PathVariable Integer postId) {
		this.postServises.deletePost(postId);
	return	new ApiResponce("post succesfully delte",true);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
		PostDto updatePost = this.postServises.updatePost(postDto, postId);
	return	new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
}
