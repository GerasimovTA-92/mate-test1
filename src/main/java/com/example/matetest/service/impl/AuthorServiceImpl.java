package com.example.matetest.service.impl;

import com.example.matetest.model.Author;
import com.example.matetest.repository.AuthorRepository;
import com.example.matetest.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Object[] findMostSuccessful() {
        return authorRepository.findMostSuccessful();
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
