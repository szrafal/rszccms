package com.example.weddingmanager.dto;

import com.example.weddingmanager.model.DiscountType;
import com.example.weddingmanager.model.GuestGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WeddingGuestRequest(
        @NotBlank @Size(max = 50) String firstName,
        @NotBlank @Size(max = 100) String lastName,
        @NotNull GuestGroup group,
        boolean invited,
        boolean confirmed,
        boolean attendingReception,
        @NotNull DiscountType discount,
        boolean serviceProvider,
        boolean accommodation,
        boolean transport,
        boolean diet,
        @Size(max = 300) String note
) {
}
