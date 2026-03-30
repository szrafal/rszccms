package com.example.weddingmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "wedding_guests")
public class WeddingGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "guest_group", nullable = false, length = 64)
    private GuestGroup group;

    @Column(name = "invited", nullable = false)
    private boolean invited;

    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Column(name = "attending_reception", nullable = false)
    private boolean attendingReception;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false, length = 32)
    private DiscountType discount;

    @Column(name = "service_provider", nullable = false)
    private boolean serviceProvider;

    @Column(name = "accommodation_required", nullable = false)
    private boolean accommodation;

    @Column(name = "transport_required", nullable = false)
    private boolean transport;

    @Column(name = "special_diet", nullable = false)
    private boolean diet;

    @Size(max = 300)
    @Column(name = "note", length = 300)
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GuestGroup getGroup() {
        return group;
    }

    public void setGroup(GuestGroup group) {
        this.group = group;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isAttendingReception() {
        return attendingReception;
    }

    public void setAttendingReception(boolean attendingReception) {
        this.attendingReception = attendingReception;
    }

    public DiscountType getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountType discount) {
        this.discount = discount;
    }

    public boolean isServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(boolean serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public boolean isAccommodation() {
        return accommodation;
    }

    public void setAccommodation(boolean accommodation) {
        this.accommodation = accommodation;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public boolean isDiet() {
        return diet;
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
