package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

// Para falar que a classe é um recurso implemetável por um controlador rest, colocamos a anotação @RestController

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//método para acessar aos usuários
	//o método precisa da anotação @GetMapping para responder ao recurso get 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); 
		//o .ok retorna a resposta com 'sucesso' no http e o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Essa é a forma adequada para inserir um recurso no banco de dados pelo spring boot
	// Pré-processamento na compilação do controlador, definindo que esse método recebe o método post do http
	// Para o objeto chegar deserializado para o tipo User, usar a anotação @RequestBody
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		// O http espera uma resposta com cabeçalho, ou seja, um endereço, essa resposta vem no formato URI, e é feito pela forma padrão do spring boot
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
