package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.repository.AssetRepository;
import com.prod.Tikar.service.BasementService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class AssetController {
        @Autowired
        AssetRepository assetRepo;

        @GetMapping(value = "/assets")
        public List<Asset> getAllAssets() {
                return assetRepo.findAll();
        }

        @GetMapping("/asset/{id}")
        public Optional<Asset> getAssetById(@PathVariable("id") long id) {
                return assetRepo.findById(id);
        }

        @GetMapping("/asset")
        public ResponseEntity<List<Asset>> getAssetsByParam(
                        @RequestParam(value = "ville", required = false) String ville,
                        @RequestParam(value = "lessor", required = false) String lessor,
                        @RequestParam(value = "addedBy", required = false) String addedBy,
                        @RequestParam(value = "matricule", required = false) Long matricule,
                        @RequestParam(value = "isActive", required = false) Boolean isActive) {
                List<Asset> assets = new ArrayList<Asset>();

                assetRepo.findAll().stream().filter(
                                asset -> ville != null && asset.getVille() != null &&
                                                asset.getVille().contains(
                                                                ville))
                                .toList().forEach(assets::add);

                assetRepo.findAll().stream().filter(
                                asset -> lessor != null && asset.getLessor() != null
                                                && asset.getLessor().getFname().contains(lessor))
                                .toList().forEach(assets::add);

                assetRepo.findAll().stream().filter(
                                asset -> addedBy != null && asset.getAddedBy() != null
                                                && asset.getAddedBy().getFName().contains(
                                                                addedBy))
                                .toList().forEach(assets::add);

                assetRepo.findAll().stream().filter(
                                asset -> matricule != null && asset.getMatricule() != null
                                                && asset.getMatricule().toString().contains(
                                                                ville))
                                .toList().forEach(assets::add);

                assetRepo.findAll().stream().filter(
                                asset -> isActive != null &&
                                                isActive == asset.isActive())
                                .toList().forEach(assets::add);

                return assets != null ? new ResponseEntity<>(assets, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
                // TODO:create other types of get queries
        }

        @DeleteMapping("/asset/{id}")
        public ResponseEntity<HttpStatus> DeleteMapping(@PathVariable(value = "id") long id) {
                assetRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        // TODO:can only handle delete of residence and basement since building parents
        // is constraints with basement
};
