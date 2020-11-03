package com.gabriel.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * No MongoDB, as entidades são separadas em documentos. Por isso, a entidade user tem a anotação @Document
 */

@Document
@EqualsAndHashCode(exclude={"name", "email", "posts"})
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;

	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
}
