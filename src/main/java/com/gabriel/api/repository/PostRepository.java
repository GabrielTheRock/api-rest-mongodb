package com.gabriel.api.repository;

import com.gabriel.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Essa classe vai conseguir realizar várias operações com o MongoDB
 */

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    /*
     * Consulta simples usando @Query do MongoDB
     */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
