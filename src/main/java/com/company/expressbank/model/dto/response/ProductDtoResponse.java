package com.company.expressbank.model.dto.response;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.model.entity.Supplier;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoResponse {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private Supplier supplier;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}