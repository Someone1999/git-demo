package com.example.documentmanagment.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity(name = "t_grif")
@AllArgsConstructor
@NoArgsConstructor
public class Grif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grif_id;
    @Column(nullable = false)
    private String grif_nomi;
}
