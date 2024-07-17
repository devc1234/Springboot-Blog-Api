package com.example.dev.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
import com.example.dev.payload.UserDto;
import com.example.dev.servises.UserServices;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	
	
	  
	
	@Autowired
	private UserServices userServices;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
	logger.info("post mapping implements");
	  
		 UserDto createUserDto= this.userServices.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	
		
		
		
		
		
 
	}
	
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userid") Integer uid){
		UserDto updateUser =this.userServices.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("userid") Integer uid){
		this.userServices.deleteUser(uid);
		return new ResponseEntity<ApiResponce>(new ApiResponce("deleted user successfully",true),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userServices.getAllUser());
	}
	
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userid){
		return ResponseEntity.ok(this.userServices.getUserById(userid));
	}
	
	
	
	
	
	
	
	
	
	
}
