package com.mgoode.bookstore.service;

import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> getBookByBarcode(String barcode ) {
        return bookRepository.findByISBN(barcode);
    }

    public void saveBook( Book book ) {
        bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id ) {
        return bookRepository.findById(id);
    }


}
