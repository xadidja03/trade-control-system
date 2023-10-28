package com.company.expressbank.model.dto.request;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import static com.company.expressbank.model.constants.Constants.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductUpdateDtoRequest {

    @Size(min = 3, max =50,message = NAME_REGEX)
    private String name;

    @Size(max =255,message = DESCRIPTION_REGEX)
    private String description;

    @Positive(message = PAYMENT_REGEX)
    private Double price;

    private Long categoryId;
    private Long supplierId;


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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
