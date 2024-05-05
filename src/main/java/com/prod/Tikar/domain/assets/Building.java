package com.prod.Tikar.domain.assets;

import com.prod.Tikar.domain.Asset;

public class Building extends Asset {
    @Override
    public String getAssetType() {
        
        return "building";
    }
}
