package com.bd.budget.controllers;


import com.bd.budget.models.Transaction;
import com.bd.budget.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> findTransactionById(@PathVariable("id") Long id) {
        Transaction transaction = transactionService.findTransactionById(id);

        return ResponseEntity.ok(transaction);
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.addTransaction(transaction);

        return ResponseEntity.ok(newTransaction);
    }

    @PutMapping("{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id,
                                                         @RequestBody Transaction updatedTransaction) {
        Transaction transaction = transactionService.updateTransaction(id, updatedTransaction);

        return ResponseEntity.ok(transaction);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);

        return ResponseEntity.ok("The transaction has been successfully deleted.");
    }



}