package com.neo.controller;

import com.neo.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/province")
public class ProvinceRestController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProvince() {
        return ResponseEntity.ok(provinceService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProvinceById(@PathVariable Integer id) {
        return ResponseEntity.ok(provinceService.getById(id));
    }
}
