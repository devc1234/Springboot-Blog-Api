package com.example.dev.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	
	@NotEmpty
	@Size(min=6,message="user name must be 6 character ")
	private String name;
	
	@Email(message="email valid enters")
	private String email;
	
     @NotEmpty
     @Size(min=3,max=10,message = "password must be 3 and 10 chars")
	private String Password;
	
	@NotNull
	private String about;
	
	
}
