package com.example.dev.servises.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.controller.UserController;
import com.example.dev.entites.User;
import com.example.dev.exeption.ResourceNotFoundExeption;
import com.example.dev.payload.UserDto;
import com.example.dev.repo.UserRepo;
import com.example.dev.servises.UserServices;

@Service
public class UserServisesimpl implements UserServices {

	private static final Logger logger = Logger.getLogger(UserServisesimpl.class.getName());
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	 private  ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		
		 User savedUser= this.userRepo.save(user);
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user =this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExeption("User","Id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		User updateUser =this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExeption("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users=this.userRepo.findAll();
		
	List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExeption("User", "Id", userId));
		this.userRepo.delete(user);
		
	}
	
	private User dtoToUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
		
	//	User user = new User();
	//	user.setId(userDto.getId());
	//	user.setName(userDto.getName());
	//	user.setEmail(userDto.getEmail());
	//	user.setAbout(userDto.getAbout());
	//	user.setPassword(userDto.getPassword());
		return user;
		
		
	}
	
	private UserDto userToDto(User user) {
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
	 //  UserDto userDto = new UserDto();
	 //  userDto.setId(user.getId());
	 //  userDto.setName(user.getName());
	 //  userDto.setEmail(user.getEmail());
	 //  userDto.setAbout(user.getAbout());
	 //  userDto.setPassword(user.getPassword());
	   
	   return userDto;
	}
}