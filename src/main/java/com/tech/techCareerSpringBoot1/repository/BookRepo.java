package com.tech.techCareerSpringBoot1.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.techCareerSpringBoot1.data.entity.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer> {
    Optional<Book> findByAuthorID(String authorId);
    Optional<List<Book>> findAllByIsDeletedFalse();

    Optional<Book> findByName(String name);

}