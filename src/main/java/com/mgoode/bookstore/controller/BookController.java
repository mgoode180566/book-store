package com.mgoode.bookstore.controller;

import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class BookController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/books/all")
    public Iterable<Book> getAllBooks() {
        log.info("Get all books");
        return bookService.getAllBooks();
    }

    @GetMapping("/books/getbookbyid")
    public Book getBookById(@RequestParam long id) {
        log.info("Get book by id " + id);
        Optional<Book> book = bookService.getBookById(id);
        return book.get();
    }

    @GetMapping("/books/getbookbyisbn")
    public ResponseEntity<Object> getBookByBarcode(@RequestParam String isbn) {
        log.info("Get book with barcode " + isbn);
        Optional<Book> book = bookService.getBookByBarcode(isbn);
        if (!book.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.accepted().body(book.get());
    }

    @PostMapping("/books/")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id) {
        Optional<Book> b = bookService.getBookById(id);
        if (!b.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        bookService.saveBook(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("books/getprice")
    public ResponseEntity getPrice( @RequestParam String ISBN, @RequestParam int qty ) {
        Optional<Book> book = bookService.getBookByBarcode(ISBN);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(book.get().calculatePrice(qty));
    }

}
