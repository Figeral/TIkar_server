package com.prod.Tikar.controller;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.model.Renter;
import com.prod.Tikar.model.assets.Basement;
import com.prod.Tikar.model.assets.Building;
import com.prod.Tikar.model.assets.Residence;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.repository.RentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RentController {
    @Autowired
    RentRepository rentRepo;

    @GetMapping("/rents")
    public List<Rent> getAllRent() {
        return rentRepo.findAll();

    }

    @GetMapping("/rent/{id}")
    public Optional<Rent> getRentById(@PathVariable(value = "id") Long id) {
        return rentRepo.findById(id);

    }

    @GetMapping("/rent")
    public ResponseEntity<List<Rent>> getRent(@RequestParam(value = "asset", required = false) Asset asset,
            @RequestParam(value = "renter", required = false) Renter renter,
            @RequestParam(value = "isActive", required = false) Boolean isActive) {
        List<Rent> rents = new ArrayList<Rent>();

        rentRepo.findAll().stream().filter(
                r -> asset != null && r.getAsset().equals(asset))
                .toList().forEach(rents::add);

        rentRepo.findAll().stream().filter(
                r -> renter != null && r.getRenter().equals(renter))
                .toList().forEach(rents::add);

        rentRepo.findAll().stream().filter(
                r -> isActive != null &&
                        isActive == r.isActive())
                .toList().forEach(rents::add);

        return rents != null ? new ResponseEntity<>(rents, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/rent")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Rent rent) {
        if (rent != null) {
            rentRepo.save(rent);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<HttpStatus> putMethodName(@PathVariable int id, @RequestBody Rent newRent) throws Exception {
        switch (newRent.getAsset()) {
            case Building building -> {
                rentRepo.updateRent(id, newRent.isActive(), newRent.getAsset(),
                        newRent.getRenter(),
                        newRent.getCost(),
                        newRent.getStartAt(),
                        newRent.getEndAt());

                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            case Residence residence -> {
                rentRepo.updateRent(id, newRent.isActive(), newRent.getAsset(),
                        newRent.getRenter(),
                        newRent.getCost(),
                        newRent.getStartAt(),
                        newRent.getEndAt());

                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            case Basement basement -> {
                rentRepo.updateRent(id, newRent.isActive(), newRent.getAsset(),
                        newRent.getRenter(),
                        newRent.getCost(),
                        newRent.getStartAt(),
                        newRent.getEndAt());

                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            default -> throw new Exception("not able to update");
        }
    }

    @DeleteMapping("/rent/{id}")
    public ResponseEntity<HttpStatus> DeleteMapping(@PathVariable(value = "id") long id) {
        try {
            rentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }
}