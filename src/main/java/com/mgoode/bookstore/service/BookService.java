package com.mgoode.bookstore.service;

import com.mgoode.bookstore.model.AntiqueBook;
import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.model.ScienceJournal;
import com.mgoode.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
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

    public void saveBook( Book book ) throws Exception {

        if ( book instanceof ScienceJournal ) {
            // its a science journal
            if ((((ScienceJournal) book).getScienceIndex() < 1 ) || (((ScienceJournal) book).getScienceIndex() > 10 )) {
                throw new Exception("Science journal must have an index between 1 and 10");
            }
        } else if ( book instanceof AntiqueBook) {
            // its a science journal
            if (((AntiqueBook) book).getReleaseYear() > 1900 ){
                throw new Exception("Antique book must have a release year before 1900");
            }
        }

        bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id ) {
        return bookRepository.findById(id);
    }


}
