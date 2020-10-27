package com.gabriel.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.api.domain.User;
import com.gabriel.api.dto.UserDTO;
import com.gabriel.api.services.UserService;

/*
 * RestController é a camada mais externa da API.
 * Controller -> Service -> Repository
 */

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	/*
	 * Transformando a lista de User em uma lista de UserDTO usando o método map e expressão lambda
	 */
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
