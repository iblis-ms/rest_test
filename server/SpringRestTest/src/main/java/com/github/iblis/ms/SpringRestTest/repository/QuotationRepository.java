package com.github.iblis.ms.SpringRestTest.repository;

import com.github.iblis.ms.SpringRestTest.model.Book;
import com.github.iblis.ms.SpringRestTest.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Book, Long> {

    @Query("Select a From Quotation a")
    List<Quotation> getQuotations();

    @Query("Select a From Author a Where a.name Like %:quotationPart%")
    List<Quotation> getQuotationsLike(@Param("quotationPart") String quotationPart);

}
