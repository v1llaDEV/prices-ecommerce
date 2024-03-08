package com.v1lladev.ecommerce.domain.ports;

import com.v1lladev.ecommerce.domain.model.Price;

import java.time.LocalDateTime;

/**
 * The interface Price persistance port.
 */
public interface PricePersistancePort {

    /**
     * Gets price by date product id brand id.
     *
     * @param date      the date
     * @param productId the product id
     * @param brandId   the brand id
     * @return the price by date product id brand id
     */
    Price getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}
