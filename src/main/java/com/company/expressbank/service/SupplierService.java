package com.company.expressbank.service;

import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.SupplierDtoResponse;
import java.util.List;
public interface SupplierService {
    GeneralResponse<String> save(SupplierDtoRequest supplierDtoRequest);
    GeneralResponse<List<SupplierDtoResponse>> findAll();
}
