package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;

//Anotação para registrar essa classe como parte do spring para ser injetado automaticamente @Component, @Service e @Repository
@Service
public class OrderService {
	//Anotação que faz a injeção de dependência
	@Autowired
	private OrderRepository userRepository;
	
	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		//Retorna do findById um objeto do tipo Optional e a função get() retorna o dado do tipo definido
		Optional<Order> obj = userRepository.findById(id);
		return obj.get();
	}
	
}