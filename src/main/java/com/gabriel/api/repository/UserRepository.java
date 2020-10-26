package com.gabriel.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.api.domain.User;

/*
 * Essa classe vai conseguir realizar várias operações com o MongoDB
 */

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
