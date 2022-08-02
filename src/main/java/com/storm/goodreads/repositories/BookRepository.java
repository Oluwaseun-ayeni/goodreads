package com.storm.goodreads.repositories;

import com.storm.goodreads.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
