package com.example.weddingmanager.controller;

import com.example.weddingmanager.model.DiscountType;
import com.example.weddingmanager.model.GuestGroup;
import com.example.weddingmanager.model.WeddingGuest;
import com.example.weddingmanager.service.WeddingGuestService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class WeddingGuestViewController {

    private final WeddingGuestService guestService;

    public WeddingGuestViewController(WeddingGuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("guests", guestService.findAll());
        return "guests/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        fillFormModel(model, new WeddingGuest());
        return "guests/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("guest") WeddingGuest guest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            fillFormModel(model, guest);
            return "guests/form";
        }
        guestService.create(guest);
        return "redirect:/guests";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        fillFormModel(model, guestService.findById(id));
        return "guests/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("guest") WeddingGuest guest,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            guest.setId(id);
            fillFormModel(model, guest);
            return "guests/form";
        }
        guestService.update(id, guest);
        return "redirect:/guests";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        guestService.delete(id);
        return "redirect:/guests";
    }

    private void fillFormModel(Model model, WeddingGuest guest) {
        model.addAttribute("guest", guest);
        model.addAttribute("groups", GuestGroup.values());
        model.addAttribute("discounts", DiscountType.values());
    }
}
