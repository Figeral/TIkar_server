package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Lessor;

import com.prod.Tikar.repository.LessorRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class LessorController {
    @Autowired
    LessorRepository lessorRepo;

    @GetMapping("/lessors")
    public List<Lessor> getAllLessor() {
        return lessorRepo.findAll();
    }

    @GetMapping("/lessor/{id}")
    public Optional<Lessor> getLessorById(@PathVariable("id") long id) {
        return lessorRepo.findById(id);
    }

    @GetMapping("/lessor")
    public ResponseEntity<List<Lessor>> getLessor(@RequestParam(value = "fname", required = false) String fname,
            @RequestParam(value = "isActive", required = false) Boolean isActive) {
        List<Lessor> lessors = new ArrayList<Lessor>();

        lessorRepo.findAll().stream().filter(
                lessor -> fname != null && lessor.getFname() != null && lessor.getFname().contains(
                        fname))
                .toList().forEach(lessors::add);

        lessorRepo.findAll().stream().filter(
                asset -> isActive != null &&
                        isActive == asset.isActive())
                .toList().forEach(lessors::add);

        // ps :primary types can't be null but their wrapper type can

        return lessors != null ? new ResponseEntity<>(lessors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // TODO:create other types of get queries
    }

    @PostMapping("/lessor")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Lessor lessor) {

        if (lessor != null) {
            lessorRepo.save(lessor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/lessor/{id}")
    public ResponseEntity<HttpStatus> putMethodName(@PathVariable(value = "id") long id, @RequestBody Lessor lessor) {
        if (lessor != null) {
            lessorRepo.updateLessor(id, lessor.isActive(), lessor.getTel(), lessor.getFname(), lessor.getLname(),
                    lessor.getPicture());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/lessor/{id}")
    public ResponseEntity<HttpStatus> DeleteMapping(@PathVariable(value = "id") long id) {
        try {
            lessorRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
