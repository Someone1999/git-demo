package com.example.documentmanagment.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity(name = "t_lavozim")
@AllArgsConstructor
@NoArgsConstructor
public class Lavozim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lavozim_id;
    private String lavozim_nomi;
}
