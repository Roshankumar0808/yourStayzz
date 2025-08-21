package com.majorProject.airBnbApp.airBnbApp.service;

import com.majorProject.airBnbApp.airBnbApp.dto.BookingDto;
import com.majorProject.airBnbApp.airBnbApp.dto.BookingRequest;
import com.majorProject.airBnbApp.airBnbApp.dto.HotelReportDto;
import com.majorProject.airBnbApp.airBnbApp.entity.Booking;
import com.majorProject.airBnbApp.airBnbApp.entity.Hotel;
import com.majorProject.airBnbApp.airBnbApp.entity.Inventory;
import com.majorProject.airBnbApp.airBnbApp.entity.Room;
import com.majorProject.airBnbApp.airBnbApp.entity.enums.BookingStatus;
import com.majorProject.airBnbApp.airBnbApp.exception.ResourceNotFoundException;
import com.majorProject.airBnbApp.airBnbApp.repository.*;
import com.majorProject.airBnbApp.airBnbApp.strategy.PricingService;
import com.stripe.model.Event;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.majorProject.airBnbApp.airBnbApp.util.AppUtils.getCurrentUser;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;
    private final CheckoutService checkoutService;
    private final PricingService pricingService;

    @Override
    @Transactional
    public BookingDto initialiseBooking(BookingRequest bookingRequest) {

        log.info("Initialising booking for hotel : {}, room: {}, date {}-{}", bookingRequest.getHotelId(),
                bookingRequest.getRoomId(), bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());

        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId()).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found with id: "+bookingRequest.getHotelId()));

        Room room = roomRepository.findById(bookingRequest.getRoomId()).orElseThrow(() ->
                new ResourceNotFoundException("Room not found with id: "+bookingRequest.getRoomId()));

        List<Inventory> inventoryList = inventoryRepository.findAndLockAvailableInventory(room.getId(),
                bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate(), bookingRequest.getRoomsCount());

        long daysCount = ChronoUnit.DAYS.between(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate())+1;

        if (inventoryList.size() != daysCount) {
            throw new IllegalStateException("Room is not available anymore");
        }

        // Reserve the room/ update the booked count of inventories
        inventoryRepository.initBooking(room.getId(), bookingRequest.getCheckInDate(),
                bookingRequest.getCheckOutDate(), bookingRequest.getRoomsCount());

        BigDecimal priceForOneRoom = pricingService.calculateTotalPrice(inventoryList);
        BigDecimal totalPrice = priceForOneRoom.multiply(BigDecimal.valueOf(bookingRequest.getRoomsCount()));

        Booking booking = Booking.builder()
                .bookingStatus(BookingStatus.RESERVED)
                .hotel(hotel)
                .room(room)
                .checkInDate(bookingRequest.getCheckInDate())
                .checkOutDate(bookingRequest.getCheckOutDate())
                .user(getCurrentUser())
                .roomsCount(bookingRequest.getRoomsCount())
                .amount(totalPrice)
                .build();

        booking = bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDto.class);
    }




    @Override
    public BookingDto addGuests(Long bookingId, List<Long> guestIdList) {
        return null;
    }

    @Override
    public String initiatePayments(Long bookingId) {
        return "";
    }

    @Override
    public void capturePayment(Event event) {

    }

    @Override
    public void cancelBooking(Long bookingId) {

    }

    @Override
    public BookingStatus getBookingStatus(Long bookingId) {
        return null;
    }

    @Override
    public List<BookingDto> getAllBookingsByHotelId(Long hotelId) {
        return List.of();
    }

    @Override
    public HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<BookingDto> getMyBookings() {
        return List.of();
    }
}
