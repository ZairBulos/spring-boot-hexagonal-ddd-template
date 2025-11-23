package com.zair.infrastructure.adapters.in.rest.handlers;

import com.zair.application.exceptions.ApplicationException;
import com.zair.domain.exceptions.DomainException;
import com.zair.infrastructure.adapters.in.rest.dtos.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    // === Domain ===
    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDomainException(DomainException ex, HttpServletRequest request) {
        log.error("Domain error: {}", ex.getMessage(), ex);
        return ErrorResponse.fromException(
                ex,
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI()
        );
    }

    // === Application ===
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleApplicationException(ApplicationException ex, HttpServletRequest request) {
        log.error("Application error: {}", ex.getMessage(), ex);
        return ErrorResponse.fromException(
                ex,
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI()
        );
    }

    // === Infrastructure ===
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        log.warn("Validation failed: {} - {}", ex.getClass().getSimpleName(), details);
        return ErrorResponse.of(
                "VALIDATION_ERROR",
                "Validation failed for one or more fields",
                HttpStatus.BAD_REQUEST.value(),
                details,
                request.getRequestURI()
        );
    }

    // === General ===
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex, HttpServletRequest request) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);
        return ErrorResponse.fromException(
                ex,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI()
        );
    }
}
