package com.example.matetest.service.mapper;

import com.example.matetest.dto.request.AuthorRequestDto;
import com.example.matetest.dto.response.AuthorResponseDto;
import com.example.matetest.model.Author;
import com.example.matetest.service.RequestDtoMapper;
import com.example.matetest.service.ResponseDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper implements RequestDtoMapper<Author, AuthorRequestDto>,
        ResponseDtoMapper<AuthorResponseDto, Author> {
    @Override
    public Author toModel(AuthorRequestDto dto) {
        Author model = new Author();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        model.setBirthDate(dto.getBirthDate());
        return model;
    }

    @Override
    public AuthorResponseDto toDto(Author model) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setPhone(model.getPhone());
        dto.setName(model.getName());
        dto.setBirthDate(model.getBirthDate());
        return dto;
    }
}
