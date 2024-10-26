package com.example.partyplanner.repository;

import com.example.partyplanner.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
