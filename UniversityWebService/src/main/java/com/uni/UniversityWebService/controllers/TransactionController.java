package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.dto.TransactionDto;
import com.uni.UniversityWebService.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private  TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<String> addNewTransaction(@RequestBody TransactionDto transactionDto) throws Exception {
        transactionService.addNewTransaction(transactionDto);
        return ResponseEntity.ok("Successful");
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions(){
        return new ResponseEntity(transactionService.findAll(), HttpStatus.OK);
    }
}
