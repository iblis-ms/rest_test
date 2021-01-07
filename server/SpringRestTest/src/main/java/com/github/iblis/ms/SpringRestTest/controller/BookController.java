package com.github.iblis.ms.SpringRestTest.controller;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.model.Book;
import com.github.iblis.ms.SpringRestTest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/find/{pattern}")
    public List<Book> getBooksLike(@PathVariable String pattern) {

        return bookService.getBooksLike(pattern);
    }

    @GetMapping("/find_books")
    public List<Book> getBooksLikeParam(@RequestParam String like) {

        return bookService.getBooksLike(like);
    }

}
