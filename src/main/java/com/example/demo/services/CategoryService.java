package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

//Anotação para registrar essa classe como parte do spring para ser injetado automaticamente @Component, @Service e @Repository
@Service
public class CategoryService {
	//Anotação que faz a injeção de dependência
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		//Retorna do findById um objeto do tipo Optional e a função get() retorna o dado do tipo definido
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
	
}