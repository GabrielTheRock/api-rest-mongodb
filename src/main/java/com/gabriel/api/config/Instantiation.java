package com.gabriel.api.config;

import com.gabriel.api.domain.Post;
import com.gabriel.api.domain.User;
import com.gabriel.api.dto.AuthorDTO;
import com.gabriel.api.dto.CommentDTO;
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

		userRepository.saveAll(Arrays.asList(gabriel, vinicius, goes));

		Post post1 = new Post(null, new AuthorDTO(gabriel), sdf.parse("21/03/2018"), "Partiu viagem", "Fui, abraços!");
		Post post2 = new Post(null, new AuthorDTO(gabriel), sdf.parse("15/06/2019"), "Novos desafios", "Novo trampo, novas oportunidades!");

		CommentDTO c1 = new CommentDTO(new AuthorDTO(vinicius), "Aí sim, heim!", sdf.parse("04/11/2020"));
		CommentDTO c2 = new CommentDTO(new AuthorDTO(vinicius), "Top.", sdf.parse("07/10/2020"));
		CommentDTO c3 = new CommentDTO(new AuthorDTO(goes), "Isso aí, voa!", sdf.parse("21/09/2020"));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);

		postRepository.saveAll(Arrays.asList(post1, post2));

		gabriel.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(gabriel);
	}
}
