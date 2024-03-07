package com.v1lladev.ecommerce.application.usescases;

import com.v1lladev.ecommerce.application.dtos.PriceDto;

import java.time.LocalDateTime;

public interface PriceUsecase {

    PriceDto getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}
