package com.majorProject.airBnbApp.airBnbApp.strategy;

import com.majorProject.airBnbApp.airBnbApp.entity.Inventory;

import java.math.BigDecimal;

public class BasePricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
