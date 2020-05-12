package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.DataBaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

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
		// Usando o método orElseThrow() testa buscar o objeto, se não tiver ele lança a excessão
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		// o método getOne() prepara o objeto monitorado, para mexer e depois efetuar uma operação com o banco de dados
		User entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	} 
	
}