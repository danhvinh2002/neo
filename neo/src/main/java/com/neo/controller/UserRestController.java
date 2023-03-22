package com.neo.controller;

import com.neo.entities.UserEntity;
import com.neo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.addUser(userEntity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.updateUser(userEntity));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }
    @GetMapping("/sortByName")
    public ResponseEntity<?> sortByName() {
        return ResponseEntity.ok(userService.sortByName());
    }
}
