package com.example.weddingmanager.service;

import com.example.weddingmanager.model.WeddingGuest;
import com.example.weddingmanager.repository.WeddingGuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingGuestService {

    private final WeddingGuestRepository repository;

    public WeddingGuestService(WeddingGuestRepository repository) {
        this.repository = repository;
    }

    public List<WeddingGuest> findAll() {
        return repository.findAll();
    }

    public WeddingGuest findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guest not found: " + id));
    }

    public WeddingGuest create(WeddingGuest guest) {
        guest.setId(null);
        return repository.save(guest);
    }

    public WeddingGuest update(Long id, WeddingGuest updatedGuest) {
        WeddingGuest existing = findById(id);
        existing.setFirstName(updatedGuest.getFirstName());
        existing.setLastName(updatedGuest.getLastName());
        existing.setGroup(updatedGuest.getGroup());
        existing.setInvited(updatedGuest.isInvited());
        existing.setConfirmed(updatedGuest.isConfirmed());
        existing.setAttendingReception(updatedGuest.isAttendingReception());
        existing.setDiscount(updatedGuest.getDiscount());
        existing.setServiceProvider(updatedGuest.isServiceProvider());
        existing.setAccommodation(updatedGuest.isAccommodation());
        existing.setTransport(updatedGuest.isTransport());
        existing.setDiet(updatedGuest.isDiet());
        existing.setNote(updatedGuest.getNote());
        return repository.save(existing);
    }

    public void delete(Long id) {
        WeddingGuest existing = findById(id);
        repository.delete(existing);
    }
}
