package com.v1lladev.ecommerce.infrastructure.adapters.repositories;


import com.v1lladev.ecommerce.infrastructure.adapters.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT TOP 1 ID, BRAND_ID, PRODUCT_ID, START_DATE, END_DATE, PRICE_LIST, PRICE, PRIORITY, CURR" +
            " FROM PRICES WHERE BRAND_ID=:brandId AND PRODUCT_ID=:productId AND :date BETWEEN START_DATE AND END_DATE" +
            " ORDER BY PRIORITY DESC", nativeQuery = true)
    Optional<PriceEntity> getPriceByDateProductIdBrandId(@Param("date") LocalDateTime date, @Param("productId") Long productId,
                                                         @Param("brandId") Long brandId);
}
