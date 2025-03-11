package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.model.BookRegistrationRequest;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;

    @GetMapping("/books")
    public String getBooks(Model model){
        List<BookDto> bookDtos = bookService.getAllBooks();
        model.addAttribute("title", "Books");
        model.addAttribute("books", bookDtos);
        return "books/index";
    }


    @GetMapping("/books/create")
    public String createBook(Model model){
        model.addAttribute("title", "Add Books");
        model.addAttribute("book", new BookRegistrationRequest());
        return "books/create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute("book") BookRegistrationRequest bookRegistrationRequest,
                             RedirectAttributes redirectAttributes){
        BookDto bookDto = bookService.registerBook(bookRegistrationRequest);

        redirectAttributes.addAttribute("registrationSuccess", "Success");
        return "redirect:/books/create";
    }

    @GetMapping("/books/delete")
    public String displayDeleteEventForm(Model model) {
        List<BookDto> bookDtos = bookService.getAllBooks();
        model.addAttribute("title", "Delete Books");
        model.addAttribute("books", bookDtos);
        return "books/delete";
    }

    @PostMapping("/books/delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] bookIds) {
        if(bookIds != null) {
            for(int id: bookIds) {
                BookDto bookDto = bookService.getBookById(id);
                bookService.deleteBook(bookMapper.bookDtoToEntity(bookDto));
            }
        }
        return "redirect:/books";
    }



}
