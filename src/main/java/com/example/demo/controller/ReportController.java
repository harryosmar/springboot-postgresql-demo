package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Transaction;
import com.example.demo.service.ReportService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/report",  produces= MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/query")
    public ResponseEntity<Page<Transaction>> purchase(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(name = "start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(name = "end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        ReportFilterParamRequestDTO req = new ReportFilterParamRequestDTO(page, size, startDate, endDate);
        return ResponseEntity.ok(this.reportService.Fetch(req));
    }
}
