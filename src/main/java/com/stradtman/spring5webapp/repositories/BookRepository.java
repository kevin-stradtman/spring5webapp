package com.stradtman.spring5webapp.repositories;

import com.stradtman.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
