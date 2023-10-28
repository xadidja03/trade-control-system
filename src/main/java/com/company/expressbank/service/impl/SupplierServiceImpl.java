package com.company.expressbank.service.impl;

import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.SupplierMapper;
import com.company.expressbank.model.constants.Constants;
import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.SupplierDtoResponse;
import com.company.expressbank.model.entity.Supplier;
import com.company.expressbank.model.enums.Exceptions;
import com.company.expressbank.repository.SupplierRepository;
import com.company.expressbank.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    @Override
    public GeneralResponse<String> save(SupplierDtoRequest supplierDtoRequest) {
        Supplier supplier= supplierMapper.supplierRequestDtoToSupplier(supplierDtoRequest);
        supplierRepository.save(supplier);

        return GeneralResponse.of(Constants.CREATED_SUCCESSFULLY,
                HttpStatus.CREATED);


    }

    @Override
    public GeneralResponse<List<SupplierDtoResponse>> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        suppliers.stream()
                .findAny()
                .orElseThrow(()-> new ApplicationException(Exceptions.SUPPLIER_NOT_FOUND));
        List<SupplierDtoResponse> supplierDtoResponses = supplierMapper.
                supplierListToSupplierResponseList(suppliers);
        return GeneralResponse.of(supplierDtoResponses, HttpStatus.ACCEPTED,
                Constants.SHOW_SUCCESSFULLY);
    }
}
