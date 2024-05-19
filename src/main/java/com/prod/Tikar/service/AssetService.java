package com.prod.Tikar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.repository.AssetRepository;

@Service
public class AssetService {
    @Autowired
    AssetRepository assetRepo;

    public List<Asset> getAssetByParam(String ville, String lessor, String addedBy, Long matricule, Boolean isActive) {
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
        return assets;
    }
}
