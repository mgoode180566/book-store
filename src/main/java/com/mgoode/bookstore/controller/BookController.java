package com.mgoode.bookstore.controller;

import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class BookController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/all")
    public Iterable<Book> getAllBooks() {
        log.info("Get all books");
        return bookService.getAllBooks();
    }

    @GetMapping("/books/getbookbyid")
    public ResponseEntity<Object> getBookById(@RequestParam long id) {
        log.info("Get book by id " + id);
        Optional<Book> book = bookService.getBookById(id);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(book.get());
    }

    @GetMapping("/books/getbookbyisbn")
    public ResponseEntity<Object> getBookByBarcode(@RequestParam String isbn) {
        log.info("Get book with barcode " + isbn);
        Optional<Book> book = bookService.getBookByBarcode(isbn);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(book.get());
    }

    @RequestMapping(value="/books/add",method = RequestMethod.POST)
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        try {
            bookService.saveBook(book);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value="/books/update",method=RequestMethod.PUT)
    public ResponseEntity<Object> updateBook(@RequestParam String isbn, @RequestBody Book book) {
        Optional<Book> b = bookService.getBookByBarcode(isbn);
        if (!b.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        book.setId(b.get().getId());
        try {
            bookService.saveBook(book);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("books/getprice")
    public ResponseEntity<Object> getPrice( @RequestParam String isbn, @RequestParam int qty ) {
        Optional<Book> book = bookService.getBookByBarcode(isbn);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(book.get().calculatePrice(qty));
    }

}
