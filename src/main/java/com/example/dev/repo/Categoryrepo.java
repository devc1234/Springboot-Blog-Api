package com.example.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entites.Category;

public interface Categoryrepo extends JpaRepository<Category, Integer>{

}
