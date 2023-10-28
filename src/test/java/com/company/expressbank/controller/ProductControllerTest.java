package com.company.expressbank.controller;

import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.model.entity.Supplier;
import com.company.expressbank.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Test
    void testDeleteProduct() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptop");
        ProductDtoResponse.ProductDtoResponseBuilder productResult = ProductDtoResponse.builder()
                .category(category)
                .description("The characteristics of product")
                .id(1L)
                .name("ASUS Vivobook")
                .price(2450.0d);

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("AAC Technologies Holdings Inc");
        ProductDtoResponse buildResult = productResult.supplier(supplier).build();
        GeneralResponse<ProductDtoResponse> buildResult2 = GeneralResponse.<ProductDtoResponse>builder()
                .data(buildResult)
                .message("All products are getting successfully!")
                .status(HttpStatus.CONTINUE)
                .timeStamp(LocalDate.of(2022, 4, 11).atStartOfDay())
                .build();
        when(productService.delete(Mockito.<Long>any())).thenReturn(buildResult2);

        ProductController productController = new ProductController(productService);
        GeneralResponse<ProductDtoResponse> response = productController.deleteProduct(1L);

        assertEquals(("All products are getting successfully!"), response.getMessage());
        assertEquals(HttpStatus.CONTINUE, response.getStatus());
        assertEquals(LocalDate.of(2022, 4, 11).atStartOfDay(), response.getTimeStamp());
        assertEquals(1L, response.getData().getId());
        assertEquals("ASUS Vivobook", response.getData().getName());
        assertEquals("The characteristics of product", response.getData().getDescription());
        assertEquals(2450.0d, response.getData().getPrice());
        assertEquals(1L, response.getData().getCategory().getId());
        assertEquals("Laptop", response.getData().getCategory().getName());
        assertEquals(1L, response.getData().getSupplier().getId());
        assertEquals("AAC Technologies Holdings Inc", response.getData().getSupplier().getName());
        assertEquals("Hi-Tech Industrial Zone, Wujin,China", response.getData().getSupplier().getAddress());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptop");

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("AAC Technologies Holdings Inc");
        GeneralResponse<String> buildResult2 = GeneralResponse.<String>builder()
                .data("Creating successfully!")
                .message(("All products are saving successfully!"))
                .status(HttpStatus.CONTINUE)
                .timeStamp(LocalDate.of(2022, 4, 11).atStartOfDay())
                .build();
        when(productService.save(Mockito.any())).thenReturn(buildResult2);

        ProductDtoRequest productDtoRequest = new ProductDtoRequest();
        productDtoRequest.setCategoryId(1L);
        productDtoRequest.setDescription("The characteristics of product");
        productDtoRequest.setName("ASUS Vivobook");
        productDtoRequest.setPrice(2450.0d);
        productDtoRequest.setSupplierId(1L);

        ProductController productController = new ProductController(productService);
        GeneralResponse<String> response = productController.save(productDtoRequest);

        assertEquals(("All products are saving successfully!"), response.getMessage());
        assertEquals(HttpStatus.CONTINUE, response.getStatus());
        assertEquals(LocalDate.of(2022, 4, 11).atStartOfDay(), response.getTimeStamp());
    }
}
