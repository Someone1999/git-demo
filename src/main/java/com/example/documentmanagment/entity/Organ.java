package com.example.documentmanagment.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity(name = "t_organ")
@AllArgsConstructor
@NoArgsConstructor
//oliy majlis, oliy kengash, vazirlar maxkamasi, boshqarmalar

public class Organ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organ_id;
    @Column(nullable = false)
    private String organ_name;

}