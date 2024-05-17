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
    AssetRepository assetRepository;
    List<Asset> assets = new ArrayList<Asset>();

}
