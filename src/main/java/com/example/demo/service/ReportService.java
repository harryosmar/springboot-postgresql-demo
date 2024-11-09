package com.example.demo.service;


import com.example.demo.dto.ReportFilterParamRequestDTO;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReportService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> Fetch(ReportFilterParamRequestDTO req) {
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        LocalDateTime startDate = req.getStartDate();
        LocalDateTime endDate = req.getEndDate();
        return this.transactionRepository.findByCreatedAtBetween(startDate, endDate, pageable);
    }
}
