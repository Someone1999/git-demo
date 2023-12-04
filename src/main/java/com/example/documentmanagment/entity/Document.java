package com.example.documentmanagment.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
@Data
@Entity(name = "t_document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long document_id;
    @OneToOne
    @JoinColumn(nullable = false,name = "attachment_id")
    private DocumentAttachment id;
    @ManyToMany
    @JoinTable(
            name = "documents_languages",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> language_id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "grif_id")
    private Grif grif_id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "shakl_id")
    private Shakl shakl_id;
    @ManyToMany
    @JoinTable(
            name = "documents_users",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> user_id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "organ_id")
    private Organ organ_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "effective_date", updatable = false)
    private Date effectiveDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date", updatable = false)
    private Date expirationDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_timestamp", updatable = false)
    private Date uploadTimestamp;

    @ManyToOne
    @JoinColumn(nullable = false,name = "status_id")
    private DocumentStatus status_id;

}
