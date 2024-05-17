package com.prod.Tikar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.repository.LessorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class LessorController {
    @Autowired
    LessorRepository lessorRepo;

    @GetMapping("/lessors")
    public List<Lessor> getAllLessor() {
        return lessorRepo.findAll();
    }

}
