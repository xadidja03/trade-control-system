package com.company.expressbank.service.impl;

import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.ProductMapper;
import com.company.expressbank.model.constants.Constants;
import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.request.ProductUpdateDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.model.entity.Product;
import com.company.expressbank.model.entity.Supplier;
import com.company.expressbank.model.enums.Exceptions;
import com.company.expressbank.repository.CategoryRepository;
import com.company.expressbank.repository.ProductRepository;
import com.company.expressbank.repository.SupplierRepository;
import com.company.expressbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final SupplierRepository supplierRepository;

    @Override
    public GeneralResponse<String>save(ProductDtoRequest productDtoRequest) {

        Product product= productMapper.productRequestDtoToProduct(productDtoRequest);
        categoryRepository.findById(productDtoRequest.getCategoryId()).orElseThrow(() -> new ApplicationException(Exceptions.CATEGORY_NOT_FOUND));
        supplierRepository.findById(productDtoRequest.getSupplierId()).orElseThrow(() -> new ApplicationException(Exceptions.SUPPLIER_NOT_FOUND));
        productRepository.save(product);
        return GeneralResponse.of (Constants.CREATED_SUCCESSFULLY, HttpStatus.CREATED);
    }

    @Override
    public GeneralResponse<List<ProductDtoResponse>> findAll() {
        List<Product> products=productRepository.findAll();
        products.stream()
                .findAny()
                .orElseThrow(()-> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND));
        List<ProductDtoResponse> productDtoResponses = productMapper.productListToProductResponseList(products);
        return GeneralResponse.of(productDtoResponses,HttpStatus.ACCEPTED, Constants.SHOW_SUCCESSFULLY);
    }

    @Override
    public GeneralResponse<ProductDtoResponse> findById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND));
        ProductDtoResponse productDtoResponse = productMapper.productToProductDtoResponse(product);

        return GeneralResponse.of(productDtoResponse,HttpStatus.ACCEPTED, Constants.FOUND_SUCCESSFULLY);
    }
    @Override
    public GeneralResponse<ProductDtoResponse> update(Long id, ProductUpdateDtoRequest productDtoRequest) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND));
        updateHelper(productDtoRequest,existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        ProductDtoResponse productDtoResponse = productMapper.productToProductDtoResponse(updatedProduct);

        return GeneralResponse.of(productDtoResponse, HttpStatus.ACCEPTED, Constants.UPDATE_SUCCESSFULLY);
    }

    @Override
    public GeneralResponse<ProductDtoResponse> delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND));

        productRepository.deleteById(id);
        ProductDtoResponse productDtoResponse = productMapper.productToProductDtoResponse(product);

        return GeneralResponse.of(productDtoResponse, HttpStatus.ACCEPTED, Constants.DELETE_SUCCESSFULLY);
    }

    public void updateHelper(ProductUpdateDtoRequest productDtoRequest, Product existingProduct) {
        existingProduct.setCategory(productDtoRequest.getCategoryId() != null ? categoryRepository.findById(productDtoRequest.getCategoryId()).orElseThrow(() -> new ApplicationException(Exceptions.CATEGORY_NOT_FOUND)) : existingProduct.getCategory());
        existingProduct.setSupplier(productDtoRequest.getSupplierId() != null ? supplierRepository.findById(productDtoRequest.getSupplierId()).orElseThrow(() -> new ApplicationException(Exceptions.SUPPLIER_NOT_FOUND)) : existingProduct.getSupplier());
        existingProduct.setName(productDtoRequest.getName() != null ? productDtoRequest.getName() : existingProduct.getName());
        existingProduct.setDescription(productDtoRequest.getDescription() != null ? productDtoRequest.getDescription() : existingProduct.getDescription());
        existingProduct.setPrice(productDtoRequest.getPrice() != null ? productDtoRequest.getPrice() : existingProduct.getPrice());
    }

}
