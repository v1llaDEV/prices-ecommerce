package com.v1lladev.ecommerce.infrastructure.rest;

import com.v1lladev.ecommerce.application.dtos.PriceDto;
import com.v1lladev.ecommerce.application.usescases.PriceUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prices")
public class PriceRestController {

    private final PriceUsecase priceUsecase;

    @GetMapping
    public ResponseEntity<PriceDto> getPriceByDateProductIdBrandId(@RequestParam(required = true) LocalDateTime date,
                                                                   @RequestParam(required = true) Long productId,
                                                                   @RequestParam(required = true) Long brandId){
        log.info("Getting price value by date, productId and brandId with params date: {}, productId: {}," +
                " brandId: {}", date, productId, brandId);
        return new ResponseEntity<>(priceUsecase.getPriceByDateProductIdBrandId(date, productId, brandId), HttpStatus.OK);
    }
}
