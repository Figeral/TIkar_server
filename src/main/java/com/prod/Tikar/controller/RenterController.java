package com.prod.Tikar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Renter;
import com.prod.Tikar.repository.RenterRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class RenterController {
    @Autowired
    RenterRepository renterRepo;

    @GetMapping("/renters")
    public List<Renter> getAllRenter() {
        return renterRepo.findAll();
    }

}
