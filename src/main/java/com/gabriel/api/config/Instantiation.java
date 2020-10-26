package com.gabriel.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabriel.api.domain.User;
import com.gabriel.api.repository.UserRepository;

/*
 *	Classe para adicionar objetos ao MongoDB direto da aplicação
 */

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel Rocha", "gabriel@gmail.com");
		User vinicius = new User(null, "Vinicius Alves", "vinicius@gmail.com");
		User goes = new User(null, "Gustavo Fiengo", "goes@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabriel, vinicius, goes));
	}
}
