package com.company.expressbank.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.ProductMapper;
import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.request.ProductUpdateDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.model.entity.Product;
import com.company.expressbank.model.entity.Supplier;
import com.company.expressbank.repository.CategoryRepository;
import com.company.expressbank.repository.ProductRepository;
import com.company.expressbank.repository.SupplierRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private CategoryRepository categoryRepository;
    @MockBean
    private ProductMapper productMapper;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @MockBean
    private SupplierRepository supplierRepository;
    @Test
    void testSave() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptops");

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("AAC Technologies Holdings Inc.");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of products");
        product.setId(1L);
        product.setName("Samsung S22");
        product.setPrice(10657.0d);
        product.setSupplier(supplier);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setName("Smartphones");
        Optional<Category> ofResult = Optional.of(category2);
        when(categoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Category category3 = new Category();
        category3.setId(1L);
        category3.setName("Headphones");

        Supplier supplier2 = new Supplier();
        supplier2.setAddress("42 Main St");
        supplier2.setId(1L);
        supplier2.setName("AAC Technologies Holdings Inc.");

        Product product2 = new Product();
        product2.setCategory(category3);
        product2.setDescription("The characteristics of products");
        product2.setId(1L);
        product2.setName("JBL");
        product2.setPrice(110.0d);
        product2.setSupplier(supplier2);
        when(productMapper.productRequestDtoToProduct(Mockito.<ProductDtoRequest>any())).thenReturn(product2);

        Supplier supplier3 = new Supplier();
        supplier3.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier3.setId(1L);
        supplier3.setName("AAC Technologies Holdings Inc.");
        Optional<Supplier> ofResult2 = Optional.of(supplier3);
        when(supplierRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        GeneralResponse<String> actualSaveResult = productServiceImpl.save(new ProductDtoRequest());
        verify(productMapper).productRequestDtoToProduct(Mockito.<ProductDtoRequest>any());
        verify(categoryRepository).findById(Mockito.<Long>any());
        verify(supplierRepository).findById(Mockito.<Long>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertEquals("CREATED", actualSaveResult.getData());
        assertEquals("Creating is successfully.", actualSaveResult.getMessage());
        assertEquals(HttpStatus.CREATED, actualSaveResult.getStatus());
    }

    @Test
    void testFindAll() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(ApplicationException.class, () -> productServiceImpl.findAll());
        verify(productRepository).findAll();
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptops");

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("AAC Technologies Holdings Inc.");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of products");
        product.setId(1L);
        product.setName("ASUS VIVOBOOK");
        product.setPrice(10440.0d);
        product.setSupplier(supplier);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setName("Smartphones");
        ProductDtoResponse.ProductDtoResponseBuilder priceResult = ProductDtoResponse.builder()
                .category(category2)
                .description("The characteristics of products")
                .id(1L)
                .name("Name")
                .price(6710.0d);

        Supplier supplier2 = new Supplier();
        supplier2.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier2.setId(1L);
        supplier2.setName("Samsung");
        ProductDtoResponse buildResult = priceResult.supplier(supplier2).build();
        when(productMapper.productToProductDtoResponse(Mockito.<Product>any())).thenReturn(buildResult);
        GeneralResponse<ProductDtoResponse> actualFindByIdResult = productServiceImpl.findById(1L);
        verify(productMapper).productToProductDtoResponse(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<Long>any());
        assertEquals("Found successfully.", actualFindByIdResult.getMessage());
        assertEquals(HttpStatus.ACCEPTED, actualFindByIdResult.getStatus());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Samsung");

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("Name");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of products");
        product.setId(1L);
        product.setName("Name");
        product.setPrice(12340.0d);
        product.setSupplier(supplier);
        Optional<Product> ofResult = Optional.of(product);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setName("Headphones");

        Supplier supplier2 = new Supplier();
        supplier2.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier2.setId(1L);
        supplier2.setName("YAC Technologies Holdings Inc.");

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setDescription("The characteristics of products");
        product2.setId(1L);
        product2.setName("Name");
        product2.setPrice(1340.0d);
        product2.setSupplier(supplier2);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Category category3 = new Category();
        category3.setId(1L);
        category3.setName("House equipments");
        ProductDtoResponse.ProductDtoResponseBuilder priceResult = ProductDtoResponse.builder()
                .category(category3)
                .description("The characteristics of products")
                .id(1L)
                .name("Name")
                .price(10.0d);

        Supplier supplier3 = new Supplier();
        supplier3.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier3.setId(1L);
        supplier3.setName("APPLE");
        ProductDtoResponse buildResult = priceResult.supplier(supplier3).build();
        when(productMapper.productToProductDtoResponse(Mockito.<Product>any())).thenReturn(buildResult);
        GeneralResponse<ProductDtoResponse> actualUpdateResult = productServiceImpl.update(1L,
                new ProductUpdateDtoRequest());
        verify(productMapper).productToProductDtoResponse(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<Long>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertEquals("Update is successfully.", actualUpdateResult.getMessage());
        assertEquals(HttpStatus.ACCEPTED, actualUpdateResult.getStatus());
    }


    @Test
    void testUpdateHelper() {
        ProductUpdateDtoRequest productDtoRequest = new ProductUpdateDtoRequest();
        Category category = new Category();
        category.setId(1L);
        category.setName("Smartphones");

        Supplier supplier = new Supplier();
        supplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        supplier.setId(1L);
        supplier.setName("AYC Technologies Holdings Inc.");

        Product existingProduct = new Product();
        existingProduct.setCategory(category);
        existingProduct.setDescription("The characteristics of products.");
        existingProduct.setId(1L);
        existingProduct.setName("Name");
        existingProduct.setPrice(1560.0d);
        existingProduct.setSupplier(supplier);
        productServiceImpl.updateHelper(productDtoRequest, existingProduct);
        assertEquals("Name", existingProduct.getName());
        assertEquals("The characteristics of products.", existingProduct.getDescription());
        assertEquals(1560.0d, existingProduct.getPrice().doubleValue());
        assertSame(category, existingProduct.getCategory());
        assertSame(supplier, existingProduct.getSupplier());
    }
    @Test
    void testDelete() {
        Product expectedProduct = new Product();
        expectedProduct.setId(1L);
        expectedProduct.setName("Samsung S23");
        expectedProduct.setDescription("The characteristics of product");
        expectedProduct.setPrice(1000.0);

        Category category = new Category();
        category.setId(1L);
        expectedProduct.setCategory(category);

        Supplier supplier = new Supplier();
        supplier.setId(1L);
        expectedProduct.setSupplier(supplier);

        when(productRepository.findById(1L)).thenReturn(Optional.of(expectedProduct));
        doNothing().when(productRepository).deleteById(1L);

        ProductDtoResponse expectedDtoResponse = new ProductDtoResponse();
        expectedDtoResponse.setId(1L);
        expectedDtoResponse.setName("Samsung S23");
        expectedDtoResponse.setDescription("The characteristics of product");
        expectedDtoResponse.setPrice(1000.0);
        expectedDtoResponse.setCategory(category);
        expectedDtoResponse.setSupplier(supplier);

        when(productMapper.productToProductDtoResponse(expectedProduct)).thenReturn(expectedDtoResponse);

        GeneralResponse<ProductDtoResponse> actualDeleteResult = productServiceImpl.delete(1L);

        assertEquals("Delete is successfully.", actualDeleteResult.getMessage());
    }

}

