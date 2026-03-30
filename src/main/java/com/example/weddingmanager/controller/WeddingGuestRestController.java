package com.example.weddingmanager.controller;

import com.example.weddingmanager.dto.WeddingGuestMapper;
import com.example.weddingmanager.dto.WeddingGuestRequest;
import com.example.weddingmanager.dto.WeddingGuestResponse;
import com.example.weddingmanager.service.WeddingGuestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class WeddingGuestRestController {

    private final WeddingGuestService guestService;

    public WeddingGuestRestController(WeddingGuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<WeddingGuestResponse> getAll() {
        return guestService.findAll().stream().map(WeddingGuestMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public WeddingGuestResponse getOne(@PathVariable Long id) {
        return WeddingGuestMapper.toResponse(guestService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeddingGuestResponse create(@Valid @RequestBody WeddingGuestRequest request) {
        return WeddingGuestMapper.toResponse(guestService.create(WeddingGuestMapper.toEntity(request)));
    }

    @PutMapping("/{id}")
    public WeddingGuestResponse update(@PathVariable Long id, @Valid @RequestBody WeddingGuestRequest request) {
        return WeddingGuestMapper.toResponse(guestService.update(id, WeddingGuestMapper.toEntity(request)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        guestService.delete(id);
    }
}
