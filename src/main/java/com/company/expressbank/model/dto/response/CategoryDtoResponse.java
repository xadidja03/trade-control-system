package com.company.expressbank.model.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoResponse {

    private Long id;
    private String name;

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
}
