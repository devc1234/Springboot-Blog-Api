package com.example.dev.servises.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.entites.Category;
import com.example.dev.entites.Post;
import com.example.dev.entites.User;
import com.example.dev.exeption.ResourceNotFoundExeption;
import com.example.dev.payload.PostDto;
import com.example.dev.repo.Categoryrepo;
import com.example.dev.repo.Postrepo;
import com.example.dev.repo.UserRepo;
import com.example.dev.servises.PostServises;


@Service
public class PostServisesimpl implements PostServises{

	
	@Autowired
	private Postrepo postrepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private Categoryrepo categoryrepo;
	
	@Override
	public PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId) {
		
		User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExeption ("User","UserId",userId));
		
		Category category = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundExeption ("Category","category Id",categoryId));
		
		Post post= this.modelMapper.map(postDto, Post.class);
		post.setImageName("defult.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
	Post newPost = this.postrepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = 	this.postrepo.findById(postId).orElseThrow(()-> new ResourceNotFoundExeption("Post", "post id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
	
		Post updatePost = this.postrepo.save(post);
		return this.modelMapper.map(updatePost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
	Post post = 	this.postrepo.findById(postId).orElseThrow(()-> new ResourceNotFoundExeption("Post", "post id", postId));
		this.postrepo.delete(post);;
	}
	

	@Override
	public List<PostDto> getAllPost() {
	List<Post>	 AllPost=this.postrepo.findAll();
	List<PostDto>   postDtos= AllPost.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
	Post post = 	this.postrepo.findById(postId).orElseThrow(()-> new ResourceNotFoundExeption("Post", "post id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundExeption("Category","Category id",categoryId));
		 List<Post> posts= this.postrepo.findByCategory(cat);
		 
                 List<PostDto>  postDtos= posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		 
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExeption("User","User id",userId)); 
		                 List<Post>   posts = this.postrepo.findByUser(user);
		                 
		              List<PostDto>  postDtos= posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
				return  postDtos;
	}

	@Override
	public List<Post> serachPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
