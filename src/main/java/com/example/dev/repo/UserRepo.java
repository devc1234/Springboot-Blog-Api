package com.example.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entites.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
