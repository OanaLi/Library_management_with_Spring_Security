package com.example.demo.dto;

import lombok.Builder;

@Builder
public record BookDto(
    Integer id,
    String title,
    String author,
    Float price){}

