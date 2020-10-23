package com.mgoode.bookstore.runner;

import com.mgoode.bookstore.model.AntiqueBook;
import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.model.ScienceJournal;
import com.mgoode.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        log.info("Add a book");
        bookService.saveBook(new Book("9781409521372","BFG","Roald Dahl",10.99));
        bookService.saveBook(new Book("9781503121379","Lord of the Rings","J.R.R. Tolkien",12.99));
        bookService.saveBook(new AntiqueBook("9781408921684","Wuthering Heights","Emily Bronte",12.99, 1850));
        bookService.saveBook(new ScienceJournal("9781111121389","Chronobiology International","Dr. Alain Reinberg",12.99, 1));

        Iterable<Book> books = bookService.getAllBooks();

        for (Book book : books) {

            System.out.println(book.toString());

            System.out.println(book.calculatePrice(10));

        }

    }
}
