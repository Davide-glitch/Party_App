package com.example.partyplanner.repository;

import com.example.partyplanner.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
