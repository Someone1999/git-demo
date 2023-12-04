package com.example.documentmanagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity(name = "t_unvon")
@AllArgsConstructor
@NoArgsConstructor
public class Unvon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unvon_id;
    private String unvon_nomi;

}
