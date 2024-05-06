package com.prod.Tikar.domain.assets;

import com.prod.Tikar.domain.Asset;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Building extends Asset {
    long numberOfBasements;
    long numberOfFloors;
    @Override
    public String getAssetType() {
        return "building";
    }
}
