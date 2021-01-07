package com.github.iblis.ms.SpringRestTest.controller;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/find/{pattern}")
    public List<Author> getAuthorsLike(@PathVariable String pattern) {

        return authorService.getAuthorsLike(pattern);
    }

    @GetMapping("/find_authors")
    public List<Author> getAuthorsLikeParam(@RequestParam String like) {

        return authorService.getAuthorsLike(like);
    }
}
