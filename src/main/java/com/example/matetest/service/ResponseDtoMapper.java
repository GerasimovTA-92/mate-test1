package com.example.matetest.service;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}
