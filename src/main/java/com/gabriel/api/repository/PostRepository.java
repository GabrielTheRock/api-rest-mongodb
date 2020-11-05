package com.gabriel.api.repository;

import com.gabriel.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Essa classe vai conseguir realizar várias operações com o MongoDB
 */

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase(String text);
}
