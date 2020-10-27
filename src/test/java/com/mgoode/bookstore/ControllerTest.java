package com.mgoode.bookstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mgoode.bookstore.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ControllerTest {

//    @LocalServerPort
//    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


//    @Test
//    public void addBook() {
//
//        Book book = new Book("0123456789", "TITLE", "AUTHOR", 10.99);
//
//        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/books/add"),
//                HttpMethod.POST, entity, String.class);
//
//
//        if ( response == null ) {
//            System.out.println("Response is null");
//        } else {
//            System.out.println("RESPONSE = " + response.toString());
//        }
//
//
//
//        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//
//        //assertTrue(actual.contains("/books/all"));
//
//    }
//

    private String createURLWithPort(String uri) {
        return "http://localhost:9091" + uri;
    }


}
