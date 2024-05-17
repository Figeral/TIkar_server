package com.prod.Tikar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Staff;
import com.prod.Tikar.repository.StaffRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    StaffRepository staffRepo;

    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

}
