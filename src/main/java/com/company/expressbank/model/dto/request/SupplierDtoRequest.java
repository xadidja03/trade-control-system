package com.company.expressbank.model.dto.request;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.company.expressbank.model.constants.Constants.*;

@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor

public class SupplierDtoRequest{
    @NotBlank(message = NAME_IS_MANDATORY)
    @Size(min = 3, max =50,message = NAME_REGEX)
    private String name;
    @NotBlank(message = ADDRESS_IS_MANDATORY )
    private String address;



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
