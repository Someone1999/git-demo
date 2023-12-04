package com.example.documentmanagment.service;
import com.example.documentmanagment.entity.DocumentStatus;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.repository.DocumentStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DocumentStatusService {
    private final DocumentStatusRepository documentStatusRepository;
    public DocumentStatusService(DocumentStatusRepository documentStatusRepository) {
        this.documentStatusRepository=documentStatusRepository;
    }

    public List<DocumentStatus> getAllDocumentStatus() {
        List<DocumentStatus> documentStatus = documentStatusRepository.findAll();
        if (documentStatus.isEmpty()) {
            throw new NotFoundException("No status found");
        }
        return documentStatus;
    }
    public Optional<DocumentStatus> getStatusById(Integer id) {
        return documentStatusRepository.findById(id);
    }

    public DocumentStatus saveStatus(DocumentStatus documentStatus) {
        return documentStatusRepository.save(documentStatus);
    }
    public DocumentStatus updateStatus(Integer id, DocumentStatus updatedStatus) {
        return documentStatusRepository.findById(id)
                .map(existingStatus -> {
                    existingStatus.setStatus_name(updatedStatus.getStatus_name());
                    return documentStatusRepository.save(existingStatus);
                })
                .orElseThrow(() -> new NotFoundException("Status not found with id: " + id));
    }
    public void deleteStatus(Integer id) {
        documentStatusRepository.deleteById(id);
    }
}


