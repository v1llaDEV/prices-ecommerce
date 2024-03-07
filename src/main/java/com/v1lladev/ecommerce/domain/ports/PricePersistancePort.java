package com.v1lladev.ecommerce.domain.ports;

import com.v1lladev.ecommerce.domain.model.Price;

import java.time.LocalDateTime;

public interface PricePersistancePort {

    Price getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}
