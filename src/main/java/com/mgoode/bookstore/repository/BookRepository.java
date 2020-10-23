package com.mgoode.bookstore.repository;

import com.mgoode.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
    public Optional<Book> findByISBN(String barcode );
}
