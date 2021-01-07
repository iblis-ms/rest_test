package com.github.iblis.ms.SpringRestTest.service;

import com.github.iblis.ms.SpringRestTest.model.Author;
import com.github.iblis.ms.SpringRestTest.model.Quotation;
import com.github.iblis.ms.SpringRestTest.repository.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuotationService {

    private final QuotationRepository quotationRepository;

    public List<Quotation> getQuotation(){
        return quotationRepository.getQuotations();
    }

    public List<Quotation> getQuotationLike(String namePattern) {

        return quotationRepository.getQuotationsLike(namePattern);
    }
}
