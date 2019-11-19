package com.example.kssaspect.controller;

import com.example.kssaspect.MedAspect.LogExecutionTime;
import com.example.kssaspect.model.Transaction;
import com.example.kssaspect.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/test")
public class UserController {

    @Autowired
    TestService testService;

    @GetMapping(path = "/aspect/before", produces = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public List<Transaction> create() throws Exception {
        return testService.findAll(true);
    }
}
