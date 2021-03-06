package com.github.iblis.ms.SpringRestTest.repository;

import com.github.iblis.ms.SpringRestTest.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a From Author a")
    List<Author> getAuthors();

    @Query("Select a From Author a Where a.name Like %:namePart%")
    List<Author> getAuthorsLike(@Param("namePart") String namePart);

}
