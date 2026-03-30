package com.example.weddingmanager.dto;

import com.example.weddingmanager.model.WeddingGuest;

public final class WeddingGuestMapper {

    private WeddingGuestMapper() {
    }

    public static WeddingGuest toEntity(WeddingGuestRequest request) {
        WeddingGuest guest = new WeddingGuest();
        guest.setFirstName(request.firstName());
        guest.setLastName(request.lastName());
        guest.setGroup(request.group());
        guest.setInvited(request.invited());
        guest.setConfirmed(request.confirmed());
        guest.setAttendingReception(request.attendingReception());
        guest.setDiscount(request.discount());
        guest.setServiceProvider(request.serviceProvider());
        guest.setAccommodation(request.accommodation());
        guest.setTransport(request.transport());
        guest.setDiet(request.diet());
        guest.setNote(request.note());
        return guest;
    }

    public static WeddingGuestResponse toResponse(WeddingGuest guest) {
        return new WeddingGuestResponse(
                guest.getId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getGroup(),
                guest.isInvited(),
                guest.isConfirmed(),
                guest.isAttendingReception(),
                guest.getDiscount(),
                guest.isServiceProvider(),
                guest.isAccommodation(),
                guest.isTransport(),
                guest.isDiet(),
                guest.getNote()
        );
    }
}
