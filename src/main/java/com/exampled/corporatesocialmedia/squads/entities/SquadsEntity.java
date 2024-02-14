package com.exampled.corporatesocialmedia.squads.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "squads")
public class SquadsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String value;
    @Column(nullable = false)
    private UUID id_office;
    @Column(nullable = false)
    private UUID id_manager;
}
