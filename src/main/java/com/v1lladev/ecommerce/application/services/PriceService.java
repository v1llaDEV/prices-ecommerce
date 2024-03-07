package com.v1lladev.ecommerce.application.services;

import com.v1lladev.ecommerce.application.dtos.PriceDto;
import com.v1lladev.ecommerce.application.mappers.PriceMapper;
import com.v1lladev.ecommerce.application.usescases.PriceUsecase;
import com.v1lladev.ecommerce.domain.model.Price;
import com.v1lladev.ecommerce.domain.model.contants.PriceConstants;
import com.v1lladev.ecommerce.domain.ports.PricePersistancePort;
import com.v1lladev.ecommerce.infrastructure.adapters.exceptions.InvalidBrandIdException;
import com.v1lladev.ecommerce.infrastructure.adapters.exceptions.InvalidProductIdException;
import com.v1lladev.ecommerce.infrastructure.adapters.exceptions.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService implements PriceUsecase {

    private final PricePersistancePort pricePersistancePort;
    private final PriceMapper priceMapper;

    private final Integer PRODUCT_ID_ZERO_VALUE = 0;//JUST FOR NOT USING MAGIC NUMBERS
    private final Integer BRAND_ID_ZERO_VALUE = 0;

    public PriceDto getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId){
        validateBrandtId(brandId);
        validateProductId(productId);
        Price priceResult = pricePersistancePort.getPriceByDateProductIdBrandId(date, productId, brandId);
        if(Objects.isNull(priceResult)){
            throw new PriceNotFoundException(PriceConstants.PRICE_NOT_FOUND);
        }
        return priceMapper.toDto(priceResult);
    }

    private void validateProductId(Long productId) {
        if(Objects.isNull(productId)){
            throw new InvalidProductIdException(PriceConstants.PRODUCT_ID_PARAMETER_CANNOT_BE_NULL);
        }

        if(productId < PRODUCT_ID_ZERO_VALUE){
            throw new InvalidProductIdException(PriceConstants.PRODUCT_ID_PARAMETER_CANNOT_BE_LESS_THAN_ZERO);
        }
    }

    private void validateBrandtId(Long brandId) {
        if(Objects.isNull(brandId)){
            throw new InvalidBrandIdException(PriceConstants.BRAND_ID_PARAMETER_CANNOT_BE_NULL);
        }

        if(brandId < BRAND_ID_ZERO_VALUE){
            throw new InvalidBrandIdException(PriceConstants.BRAND_ID_PARAMETER_CANNOT_BE_LESS_THAN_ZERO);
        }
    }
}
