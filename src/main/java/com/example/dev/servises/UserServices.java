package com.example.dev.servises;


import java.util.List;

import com.example.dev.payload.UserDto;

public interface UserServices {
	
	UserDto createUser(UserDto user);
		
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);

}
