package com.company.expressbank.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import static com.company.expressbank.model.constants.Constants.NAME_IS_MANDATORY;
import static com.company.expressbank.model.constants.Constants.NAME_REGEX;

@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoRequest {

    @Size(min = 3, max =50,message = NAME_REGEX)
    @NotBlank(message = NAME_IS_MANDATORY)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
