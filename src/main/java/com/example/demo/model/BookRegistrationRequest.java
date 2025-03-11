package com.example.demo.model;

import lombok.Data;

@Data
public class BookRegistrationRequest {
    private String title;

    private String author;

    private Float price;
}
