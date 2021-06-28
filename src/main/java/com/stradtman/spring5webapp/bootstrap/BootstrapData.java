package com.stradtman.spring5webapp.bootstrap;

import com.stradtman.spring5webapp.domain.Author;
import com.stradtman.spring5webapp.domain.Book;
import com.stradtman.spring5webapp.repositories.AuthorRepository;
import com.stradtman.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kevin = new Author("Kevin", "Smith");
        Book ddd = new Book("Domain Driven Design", "123123");
        kevin.getBooks().add(ddd);
        ddd.getAuthors().add(kevin);
        authorRepository.save(kevin);
        bookRepository.save(ddd);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without ejb", "389389389");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        System.out.println("Started in bootstrap");
    }
}
