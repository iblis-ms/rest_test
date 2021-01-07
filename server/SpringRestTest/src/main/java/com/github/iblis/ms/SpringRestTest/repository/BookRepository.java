package com.github.iblis.ms.SpringRestTest.repository;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("Select a From Book a")
    List<Book> getBooks();

    @Query("Select a From Book a Where a.name Like %:namePart%")
    List<Book> getBooksLike(@Param("namePart") String namePart);

}
