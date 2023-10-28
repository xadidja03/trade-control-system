package com.company.expressbank.controller;

import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.SupplierDtoResponse;
import com.company.expressbank.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/commerce/suppliers")
public class SupplierController {

    private final SupplierService supplierService;


    @PostMapping("/registration")
    public GeneralResponse<String> save(@RequestBody @Valid SupplierDtoRequest supplierDtoRequest) {
        log.info("request -> {}",supplierDtoRequest);
        return supplierService.save(supplierDtoRequest);
    }

    @GetMapping("/showing")
    public GeneralResponse<List<SupplierDtoResponse>> getaAllSuppliers() {
        GeneralResponse<List<SupplierDtoResponse>> getAllSuppliers = supplierService.findAll();
        log.info("{}",getAllSuppliers);
        return getAllSuppliers;
    }
}
