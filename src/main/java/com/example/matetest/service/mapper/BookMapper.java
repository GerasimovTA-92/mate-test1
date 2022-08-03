package com.example.matetest.service.mapper;

import com.example.matetest.dto.request.BookRequestDto;
import com.example.matetest.dto.response.BookResponseDto;
import com.example.matetest.model.Book;
import com.example.matetest.service.AuthorService;
import com.example.matetest.service.RequestDtoMapper;
import com.example.matetest.service.ResponseDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper implements ResponseDtoMapper<BookResponseDto, Book>,
        RequestDtoMapper<Book, BookRequestDto> {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Book toModel(BookRequestDto dto) {
        Book book = new Book();
        book.setAuthor(authorService.findById(dto.getAuthorId()));
        book.setName(dto.getName());
        book.setSoldAmount(dto.getSoldAmount());
        book.setPublishedAmount(dto.getPublishedAmount());
        return book;
    }

    @Override
    public BookResponseDto toDto(Book model) {
        return new BookResponseDto(model);
    }
}
