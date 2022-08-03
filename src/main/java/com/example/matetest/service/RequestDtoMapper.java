package com.example.matetest.service;

public interface RequestDtoMapper<M, D> {
    M toModel(D dto);
}
