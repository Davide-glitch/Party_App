package com.example.partyplanner.model;

import javax.persistence.*;

@Entity
public class Responsibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private String assignedTo;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Getters and setters
}
