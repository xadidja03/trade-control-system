package com.company.expressbank.service;

import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.request.ProductUpdateDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import java.util.List;
public interface ProductService  {
    GeneralResponse<String> save(ProductDtoRequest productDtoRequest);
    GeneralResponse<List<ProductDtoResponse>> findAll();
    GeneralResponse<ProductDtoResponse> findById(Long id);
    GeneralResponse<ProductDtoResponse> update(Long id, ProductUpdateDtoRequest productDtoRequest);
    GeneralResponse<ProductDtoResponse> delete (Long id);
}
