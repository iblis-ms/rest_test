package com.github.iblis.ms.SpringRestTest.service;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.model.Book;
import com.github.iblis.ms.SpringRestTest.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public List<Book> getBooksLike(String namePattern) {
        return bookRepository.getBooksLike(namePattern);
    }
}
