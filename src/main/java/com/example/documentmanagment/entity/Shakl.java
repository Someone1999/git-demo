package com.example.documentmanagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "t_shakl")
@AllArgsConstructor
@NoArgsConstructor
//Qonun, qaror,farmon,buyruq
public class Shakl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shakl_id;
    @Column(nullable = false)
    private String shakl_nomi;
}