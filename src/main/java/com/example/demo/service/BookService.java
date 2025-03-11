package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.model.BookRegistrationRequest;

import java.util.List;

public interface BookService {

    BookDto registerBook(BookRegistrationRequest bookRegistrationRequest); //?

    BookDto getBookById(Integer id);

    List<BookDto> getAllBooks();

    BookDto createBook(Book book);

    BookDto updateBook(Book book);

    void deleteBook(Book book);
}
