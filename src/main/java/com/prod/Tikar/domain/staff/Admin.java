package com.prod.Tikar.domain.staff;

import com.prod.Tikar.domain.Staff;

public class Admin extends Staff{
    @Override
    public String getStaffType() {
        
        return "admin";
    }
}
