package com.github.iblis.ms.SpringRestTest.service;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.getAuthors();
    }
}
