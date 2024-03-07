package com.v1lladev.ecommerce.infrastructure;

import com.v1lladev.ecommerce.domain.model.Price;
import com.v1lladev.ecommerce.domain.ports.PricePersistancePort;
import com.v1lladev.ecommerce.infrastructure.adapters.entities.PriceEntity;
import com.v1lladev.ecommerce.infrastructure.adapters.mappers.PriceEntityMapper;
import com.v1lladev.ecommerce.infrastructure.adapters.repositories.PriceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceJpaAdapter implements PricePersistancePort {

    private final PriceRepository priceRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public Price getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId) {
        Optional<PriceEntity> priceWithQuery = priceRepository.getPriceByDateProductIdBrandId(date, productId, brandId);
        return priceWithQuery.map(priceEntityMapper::toDomain).orElse(null);
    }
}
