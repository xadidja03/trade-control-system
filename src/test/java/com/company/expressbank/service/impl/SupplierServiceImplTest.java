package com.company.expressbank.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.SupplierMapper;
import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.entity.Supplier;
import com.company.expressbank.repository.SupplierRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SupplierServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SupplierServiceImplTest {
    @MockBean
    private SupplierMapper supplierMapper;

    @MockBean
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Test
    void testSave() {
        SupplierDtoRequest request = new SupplierDtoRequest();
        request.setName("AAC Technologies Holdings Inc.");
        request.setAddress("Hi-Tech Industrial Zone, Wujin,China");

        Supplier expectedSupplier = new Supplier();
        expectedSupplier.setId(1L);
        expectedSupplier.setName("AAC Technologies Holdings Inc.");
        expectedSupplier.setAddress("Hi-Tech Industrial Zone, Wujin,China");

        when(supplierMapper.supplierRequestDtoToSupplier(request)).thenReturn(expectedSupplier);
        when(supplierRepository.save(expectedSupplier)).thenReturn(expectedSupplier);

        GeneralResponse actualSaveResult = supplierServiceImpl.save(request);

        assertEquals("Creating is successfully.", actualSaveResult.getMessage());
    }


    @Test
    void testFindAll() {
        when(supplierRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(ApplicationException.class, () -> supplierServiceImpl.findAll());
        verify(supplierRepository).findAll();
    }


}

