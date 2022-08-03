package com.example.matetest.controller;

import com.example.matetest.dto.request.BookRequestDto;
import com.example.matetest.dto.response.BookResponseDto;
import com.example.matetest.dto.response.SuccessfulBookResponseDto;
import com.example.matetest.model.Book;
import com.example.matetest.service.BookService;
import com.example.matetest.service.RequestDtoMapper;
import com.example.matetest.service.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final RequestDtoMapper<Book, BookRequestDto> requestDtoMapper;
    private final ResponseDtoMapper<BookResponseDto, Book> responseDtoMapper;

    public BookController(BookService bookService,
                          RequestDtoMapper<Book, BookRequestDto> requestDtoMapper,
                          ResponseDtoMapper<BookResponseDto, Book> responseDtoMapper) {
        this.bookService = bookService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return responseDtoMapper.toDto(bookService.findById(id));
    }

    @GetMapping()
    public List<BookResponseDto> getAll() {
        return bookService.findAll().stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookResponseDto add(@RequestBody @Valid BookRequestDto requestDto) {
        Book book = requestDtoMapper.toModel(requestDto);
        return responseDtoMapper.toDto(bookService.save(book));
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid BookRequestDto requestDto) {
        Book book = requestDtoMapper.toModel(requestDto);
        book.setId(id);
        return responseDtoMapper.toDto(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/most-selling-book-by-author-name/{name}")
    public List<BookResponseDto> getMostSellingBook(@PathVariable String name) {
        return bookService.findAllByAuthor_NameContainingIgnoreCaseOrderBySoldAmountDesc(name)
                .stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-published-book-by-author-name/{name}")
    public List<BookResponseDto> getMostPublishedBook(@PathVariable String name) {
        return bookService.findAllByAuthor_NameContainingIgnoreCaseOrderByPublishedAmountDesc(name)
                .stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-successful-book-by-author-name/{name}")
    public List<SuccessfulBookResponseDto> getMostSuccessfulBook(@PathVariable String name) {
        return bookService.findAllByAuthor_NameOrderByRate(name);
    }
}
