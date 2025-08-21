package com.majorProject.airBnbApp.airBnbApp.service;

import com.majorProject.airBnbApp.airBnbApp.dto.HotelPriceResponseDto;
import com.majorProject.airBnbApp.airBnbApp.dto.HotelSearchRequest;
import com.majorProject.airBnbApp.airBnbApp.dto.InventoryDto;
import com.majorProject.airBnbApp.airBnbApp.dto.UpdateInventoryRequestDto;
import com.majorProject.airBnbApp.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
