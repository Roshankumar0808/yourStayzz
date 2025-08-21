package com.majorProject.airBnbApp.airBnbApp.strategy;

import com.majorProject.airBnbApp.airBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
