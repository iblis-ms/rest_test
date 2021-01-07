package com.github.iblis.ms.SpringRestTest.controller;

import com.github.iblis.ms.SpringRestTest.model.Book;
import com.github.iblis.ms.SpringRestTest.model.Quotation;
import com.github.iblis.ms.SpringRestTest.service.QuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuotationController {

    private final QuotationService quotationService;

    @GetMapping("/quotations")
    public List<Quotation> getQuotations(){
        return quotationService.getQuotation();
    }

    @GetMapping("/quotations/like/{pattern}")
    public List<Quotation> getQuotationsLike(@PathVariable String pattern) {

        return quotationService.getQuotationLike(pattern);
    }

    @GetMapping("/find_quotations")
    public List<Quotation> getQuotationLikeParam(@RequestParam String like) {

        return quotationService.getQuotationLike(like);
    }
}
