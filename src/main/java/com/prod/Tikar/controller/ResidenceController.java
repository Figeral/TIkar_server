package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.assets.Residence;
import com.prod.Tikar.repository.ResidenceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class ResidenceController {
    @Autowired
    ResidenceRepository residenceRepo;

    @GetMapping("asset/residences")
    public List<Residence> getAllResidence() {
        return residenceRepo.findAll();
    }

    @GetMapping("/asset/residence")
    public ResponseEntity<List<Asset>> getMethodName(@RequestParam(value = "ville", required = false) String ville) {
        List<Asset> residences = new ArrayList<Asset>();

        residenceRepo.findAll().stream().filter(
                asset -> ville != null && asset.getVille() != null && asset.getVille().contains(
                        ville))
                .toList().forEach(residences::add);

        return residences != null ? new ResponseEntity<>(residences, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/asset/residence")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Residence residence) {
        if (residence != null) {
            residenceRepo.save(residence);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // @PutMapping("/renter/{id}")
    // public ResponseEntity<HttpStatus> putMethodName(@PathVariable int id,
    // @RequestBody Renter newRenter) {
    // if (newRenter != null) {
    // renterRepo.updateStaff(id, newRenter.isActive(), newRenter.getTel(),
    // newRenter.getFname(),
    // newRenter.getLname(),
    // newRenter.getPicture());
    // return new ResponseEntity<>(HttpStatus.ACCEPTED);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    // }

    // }

}
