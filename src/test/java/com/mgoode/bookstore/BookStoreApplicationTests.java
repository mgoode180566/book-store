package com.mgoode.bookstore;

import com.mgoode.bookstore.model.AntiqueBook;
import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.model.ScienceJournal;
import com.mgoode.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookStoreApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void findByISBN() {
		Book book = new Book();
		book.setISBN("123456789");
		entityManager.persist(book);
		entityManager.flush();
		Optional<Book> result = bookRepository.findByISBN("123456789");
		assertEquals(result.get().getISBN(), book.getISBN());
	}

	@Test
	public void calculateBookPrice() {
		Book book = new Book();
		book.setPrice(12.99);
		double total = book.calculatePrice(10);
		assertEquals(129.90, total);
	}

	@Test
	public void calculateAntiqueBookPrice() {
		AntiqueBook book = new AntiqueBook();
		book.setPrice(12.99);
		double total = book.calculatePrice(10);
		assertEquals(26239.8, total);
	}

	@Test
	void contextLoads() {
	}

}
