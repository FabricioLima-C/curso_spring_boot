package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

//Anotação para registrar essa classe como parte do spring para ser injetado automaticamente @Component, @Service e @Repository
@Service
public class ProductService {
	// Anotação que faz a injeção de dependência
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		// Retorna do findById um objeto do tipo Optional e a função get() retorna o
		// dado do tipo definido
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}

}