package com.example.matetest.service;

import com.example.matetest.dto.response.SuccessfulBookResponseDto;
import com.example.matetest.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    void delete(Long id);

    List<Book> findAllByAuthor_Name(String name);

    Book findFirstByOrderBySoldAmountDesc();

    Book findFirstByOrderByPublishedAmountDesc();

    List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderBySoldAmountDesc(String title);

    List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderByPublishedAmountDesc(String title);

    List<SuccessfulBookResponseDto> findAllByAuthor_NameOrderByRate(String name);
}
