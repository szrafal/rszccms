package com.example.weddingmanager.dto;

import com.example.weddingmanager.model.DiscountType;
import com.example.weddingmanager.model.GuestGroup;

public record WeddingGuestResponse(
        Long id,
        String firstName,
        String lastName,
        GuestGroup group,
        boolean invited,
        boolean confirmed,
        boolean attendingReception,
        DiscountType discount,
        boolean serviceProvider,
        boolean accommodation,
        boolean transport,
        boolean diet,
        String note
) {
}
