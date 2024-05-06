package com.prod.Tikar.domain.assets;

import com.prod.Tikar.domain.Asset;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Residence  extends Asset{
    long numberOfHalls;

    @Override
    public String getAssetType() {
        
        return "residence";
    }
}
