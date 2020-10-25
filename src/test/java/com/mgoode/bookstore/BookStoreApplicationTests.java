package com.mgoode.bookstore;

import com.mgoode.bookstore.model.Book;
import com.mgoode.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@DataJpaTest
class BookStoreApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void findByISBN() {

		Book book = new Book();
		book.setISBN("1234567890");

		entityManager.persist(book);
		entityManager.flush();

		Optional<Book> result = bookRepository.findByISBN("123456789");

		assertEquals(result.get().getISBN(), book.getISBN());

	}

	@Test
	void contextLoads() {
	}

}
