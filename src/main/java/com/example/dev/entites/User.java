package com.example.dev.entites;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="user")



public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="user name",nullable=false,length=100)
	private String name;
	
	private String email;
	
	
	private String password;
	
	
	private String about;
	
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Post> post=new ArrayList<>();
	
	
}
