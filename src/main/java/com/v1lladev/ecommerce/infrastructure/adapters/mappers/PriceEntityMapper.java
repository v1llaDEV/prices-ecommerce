package com.v1lladev.ecommerce.infrastructure.adapters.mappers;

import com.v1lladev.ecommerce.domain.model.Price;
import com.v1lladev.ecommerce.infrastructure.adapters.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price entity mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    /**
     * To domain price.
     *
     * @param priceEntity the price entity
     * @return the price
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "curr", target = "curr")
    Price toDomain(PriceEntity priceEntity);
}
