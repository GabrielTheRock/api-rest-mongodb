package com.gabriel.api.resources;

import com.gabriel.api.domain.Post;
import com.gabriel.api.resources.util.URL;
import com.gabriel.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * RestController é a camada mais externa da API.
 * Controller -> Service -> Repository
 */

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * Aqui, é feita uma consulta por título na API. Para isso, é preciso receber o texto no endpoint /titlesearch
	 * Logo depois de um "?", é colocada a string a ser usada para consultar. Ela precisa ser decodificada para UTF-8.
	 */
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
