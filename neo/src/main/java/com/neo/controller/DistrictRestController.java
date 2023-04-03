package com.neo.controller;

import com.neo.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/district")
public class DistrictRestController {
    @Autowired
    private IDistrictService districtService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDistrict() {
        return ResponseEntity.ok(districtService.findAll());
    }

    @GetMapping("/getProvince/{id}")
    public ResponseEntity<?> getDistrictByProvinceId(@PathVariable Integer id) {
        return ResponseEntity.ok(districtService.getByProvinceId(id));
    }
}
