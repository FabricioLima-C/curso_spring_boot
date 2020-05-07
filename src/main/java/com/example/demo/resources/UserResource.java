package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

// Para falar que a classe é um recurso implemetável por um controlador rest, colocamos a anotação @RestController

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//método para acessar aos usuários
	//o método precisa da anotação @GetMapping para responder ao recurso get 
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99880-2113", "1235112");
		//o .ok retorna a resposta com 'sucesso' no http e o objeto
		return ResponseEntity.ok().body(u);
	}
	
}
