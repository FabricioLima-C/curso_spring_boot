package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;

// Para falar que a classe é um recurso implemetável por um controlador rest, colocamos a anotação @RestController

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//método para acessar aos usuários
	//o método precisa da anotação @GetMapping para responder ao recurso get 
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll(); 
		//o .ok retorna a resposta com 'sucesso' no http e o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
