package com.majorProject.airBnbApp.airBnbApp.service;

import com.majorProject.airBnbApp.airBnbApp.entity.Booking;

public interface CheckoutService {
    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}
