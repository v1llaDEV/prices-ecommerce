package com.v1lladev.ecommerce.application.mappers;


import com.v1lladev.ecommerce.application.dtos.PriceDto;
import com.v1lladev.ecommerce.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * To dto price dto.
     *
     * @param price the price
     * @return the price dto
     */
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceDto toDto(Price price);
}
