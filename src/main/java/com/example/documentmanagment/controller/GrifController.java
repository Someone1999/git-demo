package com.example.documentmanagment.controller;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.entity.Grif;
import com.example.documentmanagment.service.GrifService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/grifs")
public class GrifController {
    private final GrifService grifService;
    public GrifController(GrifService grifService) {
        this.grifService = grifService;
    }

    @GetMapping
    public ResponseEntity<List<Grif>> getAllGrifs() {
        try {
            List<Grif> grifs = grifService.getAllGrifs();
            return new ResponseEntity<>(grifs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<Grif> getGrifById(@PathVariable Integer id) {
        Optional<Grif> grif = grifService.getGrifById(id);
        return grif.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Grif> saveGrif(@RequestBody Grif grif) {
        try {
            Grif savedGrif = grifService.saveGrif(grif);
            return new ResponseEntity<>(savedGrif, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrif(@PathVariable Integer id) {
        try {
            grifService.deleteGrif(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrif(@PathVariable Integer id, @RequestBody Grif updatedGrif) {
        try {
            Grif result = grifService.updateGrif(id, updatedGrif);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}


