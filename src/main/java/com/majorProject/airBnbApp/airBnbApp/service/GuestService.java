package com.majorProject.airBnbApp.airBnbApp.service;

import com.majorProject.airBnbApp.airBnbApp.dto.GuestDto;

import java.util.List;

public interface GuestService {
    List<GuestDto> getAllGuests();

    void updateGuest(Long guestId, GuestDto guestDto);

    void deleteGuest(Long guestId);

    GuestDto addNewGuest(GuestDto guestDto);
}
