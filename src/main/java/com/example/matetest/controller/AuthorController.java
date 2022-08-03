package com.example.matetest.controller;

import com.example.matetest.dto.request.AuthorRequestDto;
import com.example.matetest.dto.response.AuthorResponseDto;
import com.example.matetest.model.Author;
import com.example.matetest.service.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final RequestDtoMapper<Author, AuthorRequestDto> requestDtoMapper;
    private final ResponseDtoMapper<AuthorResponseDto, Author> responseDtoMapper;

    public AuthorController(AuthorService authorService,
                            RequestDtoMapper<Author, AuthorRequestDto> requestDtoMapper,
                            ResponseDtoMapper<AuthorResponseDto, Author> responseDtoMapper) {
        this.authorService = authorService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping("/most-successful")
    public Object[] findMostSuccessful() {
        return authorService.findMostSuccessful();
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.findAll().stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getById(@PathVariable Long id) {
        return responseDtoMapper.toDto(authorService.findById(id));
    }

    @PostMapping
    public AuthorResponseDto add(@RequestBody @Valid AuthorRequestDto requestDto) {
        Author author = requestDtoMapper.toModel(requestDto);
        return responseDtoMapper.toDto(authorService.save(author));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid AuthorRequestDto requestDto) {
        Author author = requestDtoMapper.toModel(requestDto);
        author.setId(id);
        return responseDtoMapper.toDto(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
