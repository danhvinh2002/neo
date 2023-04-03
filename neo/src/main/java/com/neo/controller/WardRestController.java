package com.neo.controller;

import com.neo.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/wards")
public class WardRestController {
    @Autowired
    private IWardService wardService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllWard() {
        return ResponseEntity.ok(wardService.findAll());
    }

    @GetMapping("/getByDistrictId/{id}")
    public ResponseEntity<?> getByDistrictId(@PathVariable Integer id) {
        return ResponseEntity.ok(wardService.getByDistrictId(id));
    }
}
