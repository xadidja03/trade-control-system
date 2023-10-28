package com.company.expressbank.handler;

import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.model.dto.response.ExceptionResponse;
import com.company.expressbank.model.enums.Exceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handle(@NotNull ApplicationException applicationException) {
        Exceptions exceptions = applicationException.getExceptions();

        return ResponseEntity
                .status(exceptions.getStatus())
                .body(ExceptionResponse.builder()
                        .message(exceptions.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleValidationException(@NotNull BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        String errorMessage = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        if (errorMessage.isEmpty()) {
            errorMessage = "Validation error occurred!";
        }
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
