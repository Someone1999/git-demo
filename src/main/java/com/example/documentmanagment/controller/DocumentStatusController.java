package com.example.documentmanagment.controller;
import com.example.documentmanagment.entity.DocumentStatus;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.service.DocumentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/status")
public class DocumentStatusController {
    private final DocumentStatusService documentStatusService;
    public DocumentStatusController(DocumentStatusService documentStatusService){
        this.documentStatusService=documentStatusService;
    }

    @GetMapping
    public ResponseEntity<List<DocumentStatus>> getAllStatus() {
        try {
            List<DocumentStatus> documentStatus = documentStatusService.getAllDocumentStatus();
            return new ResponseEntity<>(documentStatus, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<DocumentStatus> getGrifById(@PathVariable Integer id) {
        Optional<DocumentStatus> grif = documentStatusService.getStatusById(id);
        return grif.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DocumentStatus> saveGrif(@RequestBody DocumentStatus status) {
        try {
            DocumentStatus savedStatus = documentStatusService.saveStatus(status);
            return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        try {
            documentStatusService.deleteStatus(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrif(@PathVariable Integer id, @RequestBody DocumentStatus updatedGrif) {
        try {
            DocumentStatus result = documentStatusService.updateStatus(id, updatedGrif);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
