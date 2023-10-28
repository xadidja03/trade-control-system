package com.company.expressbank.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralResponse<T> {

    private String message;

    private HttpStatus status;

    private LocalDateTime timeStamp;

    private T data;


    public static  GeneralResponse<String> of( String message, HttpStatus status) {
        return buildGeneralResponse(status.name(), status, message);
    }


    public static <T> GeneralResponse<T> of(T data, HttpStatus status, String message) {
        return buildGeneralResponse(data, status, message);
    }

    private static <T> GeneralResponse<T> buildGeneralResponse(T data, HttpStatus status, String message) {
        return GeneralResponse.<T>builder()
                .data(data)
                .status(status)
                .message(message)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public T getData() {
        return data;
    }
}
