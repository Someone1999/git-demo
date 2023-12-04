package com.example.documentmanagment.controller;
import com.example.documentmanagment.entity.Grif;
import com.example.documentmanagment.entity.Shakl;

import com.example.documentmanagment.exception.NotFoundException;

import com.example.documentmanagment.service.ShaklService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shakls")
public class ShaklController {
    private final ShaklService shaklService;
    public ShaklController(ShaklService shaklService) {
        this.shaklService = shaklService;
    }

    @GetMapping
    public ResponseEntity<?> getAllShakls() {
        try {
            List<Shakl> shakl = shaklService.getAllShakls();
            return new ResponseEntity<>(shakl, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Shakl> getGrifById(@PathVariable Integer id) {
        Optional<Shakl> shakl = shaklService.getShaklById(id);
        return shakl.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Shakl> saveShakl(@RequestBody Shakl shakl) {
        Shakl savedShakl = shaklService.saveShakl(shakl);
        return new ResponseEntity<>(savedShakl, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShakl(@PathVariable Integer id, @RequestBody Shakl updateShakl) {
        try {
            Shakl result = shaklService.updateShakl(id, updateShakl);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShakl(@PathVariable Integer id) {
        shaklService.deleteShakl(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

