package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Renter;
import com.prod.Tikar.model.Staff;
import com.prod.Tikar.repository.RenterRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/renter")
    public ResponseEntity<List<Renter>> getRenter(@RequestParam(value = "fname", required = false) String fname,
            @RequestParam(value = "isActive", required = false) Boolean isActive) {
        List<Renter> renters = new ArrayList<Renter>();

        renterRepo.findAll().stream().filter(
                renter -> fname != null && renter.getFname() != null && renter.getFname().contains(fname))
                .toList().forEach(renters::add);

        renterRepo.findAll().stream().filter(
                renter -> isActive != null &&
                        isActive == renter.isActive())
                .toList().forEach(renters::add);

        return renters != null ? new ResponseEntity<>(renters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // TODO:create other types of get queries
    }

    @PostMapping("/renter")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Renter renter) {
        if (renter != null) {
            renterRepo.save(renter);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/renter/{id}")
    public ResponseEntity<HttpStatus> putMethodName(@PathVariable int id, @RequestBody Renter newRenter) {
        if (newRenter != null) {
            renterRepo.updateStaff(id, newRenter.isActive(), newRenter.getTel(),
                    newRenter.getFname(),
                    newRenter.getLname(),
                    newRenter.getPicture());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/renter/{id}")
    public ResponseEntity<HttpStatus> DeleteMapping(@PathVariable(value = "id") long id) {
        try {
            renterRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }
}
