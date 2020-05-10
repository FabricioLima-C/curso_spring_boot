package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

// Para falar que a classe é um recurso implemetável por um controlador rest, colocamos a anotação @RestController

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//método para acessar aos usuários
	//o método precisa da anotação @GetMapping para responder ao recurso get 
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll(); 
		//o .ok retorna a resposta com 'sucesso' no http e o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
