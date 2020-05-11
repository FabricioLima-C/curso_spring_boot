package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

//Anotação para registrar essa classe como parte do spring para ser injetado automaticamente @Component, @Service e @Repository
@Service
public class UserService {
	//Anotação que faz a injeção de dependência
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		//Retorna do findById um objeto do tipo Optional e a função get() retorna o dado do tipo definido
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
}