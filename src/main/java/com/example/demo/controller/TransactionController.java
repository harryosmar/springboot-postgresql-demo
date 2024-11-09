package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.TransactionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/transaction",  produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> purchase(@RequestBody PurchaseRequestDTO req) {
        PurchaseResponseDTO purchase = this.transactionService.Purchase(req);
        return ResponseEntity.ok(purchase);
    }

    @PostMapping("/refund")
    public ResponseEntity<RefundResponseDTO> refund(@RequestBody RefundRequestDTO userDTO) {
        RefundResponseDTO refund = this.transactionService.refund(userDTO);
        return ResponseEntity.ok(refund);
    }
}
