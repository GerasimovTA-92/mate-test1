package com.example.matetest.service;

import com.example.matetest.model.Author;
import java.util.List;

public interface AuthorService {
    Author save(Author author);

    List<Author> findAll();

    Author findById(Long id);

    Object[] findMostSuccessful();

    void delete(Long id);
}
