package ru.geekbrains.spring_dz6_api_sulagaevdv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity(name = "notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @CreationTimestamp
    @Column(name = "date_create")
    private LocalDate date_create;
}
