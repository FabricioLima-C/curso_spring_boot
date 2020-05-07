package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

//Interface CommandLineRunner serve para executar os comandos no início da aplicação
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	//Instanciar a dependência de fraco acoplamento usando o spring, usando a anotação Autowired
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		//passo uma lista de objetos e salva a lista no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
