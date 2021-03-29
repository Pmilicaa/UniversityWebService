package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.dto.TransactionDto;
import com.uni.UniversityWebService.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

            private final TransactionService transactionService;

            @PostMapping("/add")
            public ResponseEntity<String> addNewTransaction(@RequestBody TransactionDto transactionDto) throws Exception {
                transactionService.addNewTransaction(transactionDto);
                return ResponseEntity.ok("Successful");
            }
}
