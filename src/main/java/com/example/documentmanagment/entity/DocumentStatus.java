package com.example.documentmanagment.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity(name = "t_status")
@AllArgsConstructor
@NoArgsConstructor
public class DocumentStatus {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String status_name;
}

