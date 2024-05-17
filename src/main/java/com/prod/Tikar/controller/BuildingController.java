package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.assets.Building;
import com.prod.Tikar.repository.BuildingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class BuildingController {
    @Autowired
    BuildingRepository buildingRepo;

    @GetMapping("/asset/buildings")
    public List<Building> getAllBuildings() {
        return buildingRepo.findAll();
    }

    @GetMapping("/asset/building")
    public ResponseEntity<List<Asset>> getMethodName(@RequestParam(value = "ville", required = false) String ville) {
        List<Asset> buildings = new ArrayList<Asset>();

        buildingRepo.findAll().stream().filter(
                asset -> ville != null && asset.getVille() != null && asset.getVille().contains(
                        ville))
                .toList().forEach(buildings::add);

        return buildings != null ? new ResponseEntity<>(buildings, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
