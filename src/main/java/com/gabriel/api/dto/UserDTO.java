package com.gabriel.api.dto;

import java.io.Serializable;

import com.gabriel.api.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * O DTO (Data Transfer Object) tem o objetivo de carregar os dados de uma entidade de forma simples.
 * Permite que a aplicação retorne apenas alguns dados de um objeto e customize os retornos de acordo com a requisição. 
 */

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
}
