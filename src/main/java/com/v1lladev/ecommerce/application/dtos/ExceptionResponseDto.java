package com.v1lladev.ecommerce.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Exception response dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

    private Integer status;
    private String error;
    private String path;
    private LocalDateTime timestamp;

}
