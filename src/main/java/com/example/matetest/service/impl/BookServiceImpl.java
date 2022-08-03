package com.example.matetest.service.impl;

import com.example.matetest.dto.response.SuccessfulBookResponseDto;
import com.example.matetest.model.Book;
import com.example.matetest.repository.BookRepository;
import com.example.matetest.service.BookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllByAuthor_Name(String name) {
        return bookRepository.findAllByAuthor_Name(name);
    }

    @Override
    public Book findFirstByOrderBySoldAmountDesc() {
        return bookRepository.findFirstByOrderBySoldAmountDesc();
    }

    @Override
    public Book findFirstByOrderByPublishedAmountDesc() {
        return bookRepository.findFirstByOrderByPublishedAmountDesc();
    }

    @Override
    public List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderBySoldAmountDesc(String title) {
        return bookRepository.findAllByAuthor_NameContainingIgnoreCaseOrderBySoldAmountDesc(title);
    }

    @Override
    public List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderByPublishedAmountDesc(
            String title) {
        return bookRepository
                .findAllByAuthor_NameContainingIgnoreCaseOrderByPublishedAmountDesc(title);
    }

    @Override
    public List<SuccessfulBookResponseDto> findAllByAuthor_NameOrderByRate(String name) {
        return bookRepository.findAllByAuthor_NameOrderByRate(name);
    }
}
