package com.example.documentmanagment.controller;
import com.example.documentmanagment.entity.Organ;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.service.OrganService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organs")
public class OrganController {
    private final OrganService organService;
    public OrganController(OrganService organService) {
        this.organService = organService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrgans() {
        try {
            List<Organ> organs = organService.getAllOrgans();
            return new ResponseEntity<>(organs, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organ> getOrganById(@PathVariable Integer id) {
        return organService.getOrganById(id)
                .map(organ -> new ResponseEntity<>(organ, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Organ> saveOrgan(@RequestBody Organ organ) {
        Organ savedOrgan = organService.saveOrgan(organ);
        return new ResponseEntity<>(savedOrgan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrgan(@PathVariable Integer id, @RequestBody Organ updatedOrgan) {
        try {
            Organ result = organService.updateOrgan(id, updatedOrgan);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrgan(@PathVariable Integer id) {
        organService.deleteOrgan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
