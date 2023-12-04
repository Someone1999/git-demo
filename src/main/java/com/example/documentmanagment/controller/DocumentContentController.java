package com.example.documentmanagment.controller;
import com.example.documentmanagment.entity.DocumentAttachment;
import com.example.documentmanagment.service.DocumentContentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentContentController {

    private final DocumentContentService documentService;

    public DocumentContentController(DocumentContentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<DocumentAttachment> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            String name = file.getOriginalFilename();
            String contentType = file.getContentType();
            DocumentAttachment savedDocument = documentService.saveDocument(name, contentType, data);
            return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        DocumentAttachment document = documentService.getDocumentById(id);
        if (document != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(document.getContentType()));
            headers.setContentDispositionFormData(document.getName(), document.getName());
            return new ResponseEntity<>(document.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<DocumentAttachment>> getAllDocuments() {
        List<DocumentAttachment> documents = documentService.getAllDocuments();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

}

