package com.prod.Tikar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Staff;
import com.prod.Tikar.repository.StaffRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    StaffRepository staffRepo;

    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    @GetMapping("/staff/{id}")
    public Optional<Staff> getAssetById(@PathVariable("id") long id) {
        return staffRepo.findById(id);
    }

    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getStaff(@RequestParam(value = "fname", required = false) String fname,
            @RequestParam(value = "role", required = false) String role,
            @RequestParam(value = "isActive", required = false) Boolean isActive) {
        List<Staff> staffs = new ArrayList<Staff>();

        staffRepo.findAll().stream().filter(
                staff -> fname != null && staff.getFName() != null && staff.getFName().contains(fname))
                .toList().forEach(staffs::add);

        staffRepo.findAll().stream().filter(
                staff -> role != null && staff.getRole() != null
                        && staff.getRole().contains(role))
                .toList().forEach(staffs::add);

        staffRepo.findAll().stream().filter(
                staff -> isActive != null &&
                        isActive == staff.isActive())
                .toList().forEach(staffs::add);

        return staffs != null ? new ResponseEntity<>(staffs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // TODO:create other types of get queries
    }

    @PostMapping("/staff")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody Staff staff) {
        if (staff != null) {
            staffRepo.save(staff);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<HttpStatus> putMethodName(@PathVariable int id, @RequestBody Staff newStaff) {
        if (newStaff != null) {
            staffRepo.updateStaff(id, newStaff.isActive(), newStaff.getRole(), newStaff.getTel(), newStaff.getFName(),
                    newStaff.getLName(),
                    newStaff.getPassword(),
                    newStaff.getPicture());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<HttpStatus> DeleteMapping(@PathVariable(value = "id") long id) {
        try {
            staffRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }
}
