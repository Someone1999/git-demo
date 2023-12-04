package com.example.documentmanagment.service;
import com.example.documentmanagment.entity.DocumentAttachment;
import com.example.documentmanagment.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class DocumentContentService {

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentAttachment saveDocument(String name, String contentType, byte[] data) {
        DocumentAttachment document = new DocumentAttachment();
        document.setName(name);
        document.setContentType(contentType);
        document.setData(data);
        return documentRepository.save(document);
    }

    public DocumentAttachment getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public List<DocumentAttachment> getAllDocuments() {
        return documentRepository.findAll();
    }
}
