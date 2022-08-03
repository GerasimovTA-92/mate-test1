package com.example.matetest.service;

import com.example.matetest.model.Author;
import com.example.matetest.model.Book;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void inject() {
        Author alex = new Author();
        alex.setBirthDate(LocalDate.now());
        alex.setEmail("alex@test.ua");
        alex.setName("Alex");
        alex.setPhone("0507509484");
        authorService.save(alex);

        Author bob = new Author();
        bob.setName("Bob");
        bob.setEmail("bob@test.ua");
        bob.setBirthDate(LocalDate.now());
        bob.setPhone("0507509485");
        authorService.save(bob);

        Book home = new Book();
        home.setAuthor(alex);
        home.setName("Home");
        home.setPublishedAmount(15000L);
        home.setSoldAmount(10000L);
        bookService.save(home);

        Book soccer = new Book();
        soccer.setAuthor(alex);
        soccer.setName("Soccer in USA");
        soccer.setPublishedAmount(20000L);
        soccer.setSoldAmount(19000L);
        bookService.save(soccer);
    }
}
