package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.model.BookRegistrationRequest;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl  implements BookService{

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;


    @Override
    public BookDto registerBook(BookRegistrationRequest bookRegistrationRequest) {
        Book book = Book.builder()
                .title(bookRegistrationRequest.getTitle())
                .author(bookRegistrationRequest.getAuthor())
                .price(bookRegistrationRequest.getPrice())
                .build();

        return this.createBook(book);
    }


    @Override
    public BookDto getBookById(Integer id) {
        return bookMapper.bookEntityToDto(bookRepository.findById(id).orElse(null));
    }

    public List<BookDto> getAllBooks(){
        return bookMapper.bookListEntityToDto(bookRepository.findAll());
    }

    public BookDto createBook(Book book){
        return bookMapper.bookEntityToDto(bookRepository.save(book));
    }

    public BookDto updateBook(Book book){
        return bookMapper.bookEntityToDto(bookRepository.save(book));
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }
}
