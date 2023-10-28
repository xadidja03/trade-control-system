package com.company.expressbank.mapper;

import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.SupplierDtoResponse;
import com.company.expressbank.model.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface SupplierMapper {
    @Mapping(target = "id",ignore = true)
    Supplier supplierRequestDtoToSupplier(SupplierDtoRequest supplierDtoRequest);
    SupplierDtoResponse supplierToSupplierDtoResponse(Supplier supplier);
    List<SupplierDtoResponse> supplierListToSupplierResponseList(List<Supplier> supplierList);


}