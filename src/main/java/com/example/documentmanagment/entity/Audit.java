package com.example.documentmanagment.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@Entity(name = "t_audit")
@AllArgsConstructor
@NoArgsConstructor

public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer audit_id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "incident_id")
    private Incident incident_id;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    public Audit(LocalDateTime timestamp) {
        // Set the timestamp to the current time when creating an instance
        this.timestamp = LocalDateTime.now();
    }


}