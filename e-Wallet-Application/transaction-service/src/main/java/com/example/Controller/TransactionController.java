package com.example.Controller;

import com.example.DTO.TransactionCreateRequest;
import com.example.Service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transact")
    public String createTransaction(@RequestBody @Valid TransactionCreateRequest request) throws JsonProcessingException {
      return  transactionService.createTransaction(request);
    }
}
