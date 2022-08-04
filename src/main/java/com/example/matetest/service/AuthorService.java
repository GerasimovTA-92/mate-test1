package com.example.matetest.service;

import com.example.matetest.model.Author;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface AuthorService {
    Author save(Author author);

    List<Author> findAll();

    Author findById(Long id);

    Object[] findMostSuccessful(PageRequest pageRequest);

    void delete(Long id);
}
