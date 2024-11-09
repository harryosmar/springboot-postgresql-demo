package com.example.demo.service;

import com.example.demo.dto.PurchaseRequestDTO;
import com.example.demo.dto.PurchaseResponseDTO;
import com.example.demo.dto.RefundRequestDTO;
import com.example.demo.dto.RefundResponseDTO;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.StockIsNotEnoughtException;
import com.example.demo.exception.TransactionNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.Transaction;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public PurchaseResponseDTO Purchase(PurchaseRequestDTO req) {
        Product product = this.productRepository.findProductWithLock(req.getProductId());
        if (product == null) {
            throw new ProductNotFoundException();
        }

        Integer currentStock = product.getStock();
        if (currentStock < req.getQty()) {
            throw new StockIsNotEnoughtException();
        }
        int newStock = currentStock - req.getQty();
        product.setStock(newStock);
        this.productRepository.save(product);

        Transaction transaction = new Transaction();
        transaction.setProductId(req.getProductId());
        transaction.setQty(req.getQty());
        Transaction newTransaction = this.transactionRepository.save(transaction);

        return new PurchaseResponseDTO(newTransaction.getId());
    }

    @Transactional
    public RefundResponseDTO refund(RefundRequestDTO req) {
        Optional<Transaction> existingOptTransaction = this.transactionRepository.findById(req.getTransactionId());
        if (existingOptTransaction.isEmpty()) {
            throw new TransactionNotFoundException();
        }
        Transaction existingTransaction = existingOptTransaction.get();


        Product product = existingTransaction.getProduct();
        if (product == null) {
            throw new ProductNotFoundException();
        }

        Integer currentStock = product.getStock();
        int newStock = currentStock + existingTransaction.getQty();
        product.setStock(newStock);
        this.productRepository.save(product);

        existingTransaction.setVoid(true);
        this.transactionRepository.save(existingTransaction);

        return new RefundResponseDTO(existingTransaction.getId(), true);
    }
}
