package com.example.weddingmanager.repository;

import com.example.weddingmanager.model.WeddingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeddingGuestRepository extends JpaRepository<WeddingGuest, Long> {
}
