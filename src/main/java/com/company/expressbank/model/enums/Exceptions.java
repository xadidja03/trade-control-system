package com.company.expressbank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@AllArgsConstructor
public enum Exceptions {
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND,"Product not found!",LocalDateTime.now()),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"Category not found!",LocalDateTime.now()),
    SUPPLIER_NOT_FOUND(HttpStatus.NOT_FOUND,"Supplier not found!",LocalDateTime.now());

    private final HttpStatus status;
    private final String message;
    private final LocalDateTime timeStamp;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
