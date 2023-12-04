package com.example.documentmanagment.repository;

import com.example.documentmanagment.entity.DocumentAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentAttachment,Long> {

}
