package com.gabriel.api.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.api.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User gabriel = new User("1", "Gabriel Rocha", "gabriel@hotmail.com");
		User vinicius = new User("2", "Vinicius Alves", "vinicius@hotmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(gabriel, vinicius));
		return ResponseEntity.ok().body(list);
	}
}
