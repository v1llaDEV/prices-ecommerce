package com.v1lladev.ecommerce.infrastructure.rest;

import com.v1lladev.ecommerce.application.dtos.ExceptionResponseDto;
import com.v1lladev.ecommerce.domain.model.contants.PriceConstants;
import com.v1lladev.ecommerce.infrastructure.adapters.exceptions.CustomInvalidParameterException;
import com.v1lladev.ecommerce.infrastructure.adapters.exceptions.PriceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * The type Exception controller.
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    /**
     * The constant EMPTY_STRING.
     */
    public final static String EMPTY_STRING = "";

    /**
     * Handle custom invalid parameter exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleCustomInvalidParameterException(final PriceNotFoundException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, HttpStatus.NOT_FOUND.value(), EMPTY_STRING);
    }

    /**
     * Handle custom invalid parameter exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(CustomInvalidParameterException.class)
    public ResponseEntity<ExceptionResponseDto> handleCustomInvalidParameterException(final CustomInvalidParameterException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, HttpStatus.BAD_REQUEST.value(), EMPTY_STRING);
    }

    /**
     * Handle missing servlet request parameter exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponseDto> handleMissingServletRequestParameterException(final MissingServletRequestParameterException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, HttpStatus.BAD_REQUEST.value(), EMPTY_STRING);
    }

    /**
     * Http request method not supported exception exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponseDto> HttpRequestMethodNotSupportedExceptionException(final HttpRequestMethodNotSupportedException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, HttpStatus.METHOD_NOT_ALLOWED.value(), EMPTY_STRING);
    }

    /**
     * Handle no resource found exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleNoResourceFoundException(final NoResourceFoundException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, HttpStatus.NOT_FOUND.value(), EMPTY_STRING);
    }

    /**
     * Handle method argument type mismatch exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, BAD_REQUEST.value(), String.format(PriceConstants.VALIDATION_PARAMETER_ERROR, exception.getPropertyName(), exception.getValue()));
    }

    /**
     * Handle general exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGeneralException(final Exception exception, final HttpServletRequest request) {
        return handleExceptionResponseDto(exception, request, INTERNAL_SERVER_ERROR.value(), "");
    }

    private ResponseEntity<ExceptionResponseDto> handleExceptionResponseDto(Exception exception, HttpServletRequest request, Integer httpStatus, String customMessage) {
        log.error(String.format("Exception -> CODE: %s - MESSAGE: %s - TIMESTAMP: %s - PATH: %s",
                httpStatus, exception.getMessage(), LocalDateTime.now(), request.getRequestURI()));
        return ResponseEntity
                .status(httpStatus)
                .body(ExceptionResponseDto.builder()
                        .status(httpStatus)
                        .error(customMessage.isBlank() ? exception.getMessage() : customMessage)
                        .path(request.getRequestURI())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
