package com.prod.Tikar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Rent;
import com.prod.Tikar.repository.RentRepository;

@RestController
@RequestMapping("/api")
public class RentController {
    @Autowired
    RentRepository rentRepo;

    @GetMapping("/rents")
    public List<Rent> getAllRent() {
        return rentRepo.findAll();

    }
}
