package com.example.BookApplication.Contoroller;


import com.example.BookApplication.DTO.BookResponse;
import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Model.ReadingStatus;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.Service.GoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    GoogleBooksService googleBooksService;

    @GetMapping("/book-list")
    public String bookList(Model model){
//        List<Book> bookList = service.findAll();
        List<Book> bookList = service.findAllSortedById();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @GetMapping("/book-register")
    public String bookRegister(Model model){
        model.addAttribute("book", new Book());
        return "register";
    }

    @PostMapping("/book-register")
    public String create(@ModelAttribute Book book, Model model){
        service.crateBook(book);
        return "redirect:/book-list";

    }

    @GetMapping("/search")
    public Mono<ModelAndView> searchBooks(@RequestParam String query, Model model){
        return googleBooksService.searchBooks(query)
                .map(bookResponse -> {
                ModelAndView modelAndView = new ModelAndView("register");
                modelAndView.addObject("books", bookResponse.getItems());
                return modelAndView;
                });
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        service.deleteBookById(id);
        return "redirect:/book-list";
    }

    @PostMapping("/update-status")
    public String updateStatus(@RequestParam int id, @RequestParam ReadingStatus status){
        service.updateBookStatus(id, status);
        return "redirect:/book-list";
    }
}
