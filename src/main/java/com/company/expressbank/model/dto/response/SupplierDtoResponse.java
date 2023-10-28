package com.company.expressbank.model.dto.response;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDtoResponse {

    private Long id;
    private String name;
    private String address;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
