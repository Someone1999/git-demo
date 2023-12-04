package com.example.documentmanagment.repository;

import com.example.documentmanagment.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentStatusRepository extends JpaRepository<DocumentStatus,Integer> {

}
