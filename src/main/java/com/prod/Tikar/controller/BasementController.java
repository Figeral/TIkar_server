package com.prod.Tikar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.assets.Basement;
import com.prod.Tikar.repository.BasementRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BasementController {
    @Autowired
    BasementRepository basementRepo;

    @GetMapping("/asset/building/basements")
    public List<Basement> getAllBasements() {
        return basementRepo.findAll();
    }

    @PostMapping("/asset/building/basement")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Basement basement) {
        try {
            basementRepo.save(basement);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}