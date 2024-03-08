package com.v1lladev.ecommerce.application.usescases;

import com.v1lladev.ecommerce.application.dtos.PriceDto;

import java.time.LocalDateTime;

/**
 * The interface Price usecase.
 */
public interface PriceUsecase {

    /**
     * Gets price by date product id brand id.
     *
     * @param date      the date
     * @param productId the product id
     * @param brandId   the brand id
     * @return the price by date product id brand id
     */
    PriceDto getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}
