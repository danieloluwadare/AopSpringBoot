package com.example.kssaspect.service;

import com.example.kssaspect.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    public List<Transaction> findAll(boolean throwExcep) throws Exception {
        if(throwExcep){
            throw new Exception("For Aspect alone");
        }
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, "200", "C"));
        transactions.add(new Transaction(2, "200", "C"));
        transactions.add(new Transaction(3, "200", "C"));
        transactions.add(new Transaction(4, "200", "C"));
        transactions.add(new Transaction(5, "200", "C"));

        return transactions;

    }
}
