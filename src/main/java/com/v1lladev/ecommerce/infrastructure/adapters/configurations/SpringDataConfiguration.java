package com.v1lladev.ecommerce.infrastructure.adapters.configurations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Spring data configuration.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.v1lladev.ecommerce.infrastructure.adapters.repositories")
@EntityScan(basePackages = "com.v1lladev.ecommerce.infrastructure.adapters.entities")
@Data
@NoArgsConstructor
public class SpringDataConfiguration {
}
