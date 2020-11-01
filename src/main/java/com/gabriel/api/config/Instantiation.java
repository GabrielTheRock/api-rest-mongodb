package com.gabriel.api.config;

import com.gabriel.api.domain.Post;
import com.gabriel.api.domain.User;
import com.gabriel.api.repository.PostRepository;
import com.gabriel.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/*
 *	Classe para adicionar objetos ao MongoDB direto da aplicação
 */

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User gabriel = new User(null, "Gabriel Rocha", "gabriel@gmail.com");
		User vinicius = new User(null, "Vinicius Alves", "vinicius@gmail.com");
		User goes = new User(null, "Gustavo Fiengo", "goes@gmail.com");

		Post post1 = new Post(null, vinicius, sdf.parse("21/03/2018"), "Partiu viagem", "Fui, abraços!");
		Post post2 = new Post(null, gabriel, sdf.parse("15/06/2019"), "Novos desafios", "Novo trampo, novas oportunidades!");

		userRepository.saveAll(Arrays.asList(gabriel, vinicius, goes));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
