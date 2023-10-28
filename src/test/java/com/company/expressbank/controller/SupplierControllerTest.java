package com.company.expressbank.controller;
import com.company.expressbank.model.dto.request.SupplierDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.SupplierDtoResponse;
import com.company.expressbank.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SupplierControllerTest {

    private SupplierController supplierController;
    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        supplierService = mock(SupplierService.class);
        supplierController = new SupplierController(supplierService);
    }

    @Test
    void testGetAllSuppliers() {
        List<SupplierDtoResponse> supplierList = new ArrayList<>();
        GeneralResponse<List<SupplierDtoResponse>> expectedResponse = GeneralResponse
                .<List<SupplierDtoResponse>>builder()
                .data(supplierList)
                .message("All suppliers are getting successfully!")
                .status(HttpStatus.CONTINUE)
                .build();

        when(supplierService.findAll()).thenReturn(expectedResponse);

        GeneralResponse<List<SupplierDtoResponse>> result = supplierController.getaAllSuppliers();
        assertEquals(expectedResponse.getData(), result.getData());
        assertEquals(expectedResponse.getMessage(), result.getMessage());
        assertEquals(expectedResponse.getStatus(), result.getStatus());
    }

    @Test
    void testSave() {
        SupplierDtoRequest request = new SupplierDtoRequest();
        request.setAddress("Hi-Tech Industrial Zone, Wujin,China");
        request.setName("AAC Technologies Holdings Inc");

        SupplierDtoResponse response = SupplierDtoResponse.builder()
                .id(1L)
                .name("AAC Technologies Holdings Inc")
                .address(null)
                .build();

        GeneralResponse<String> expectedResponse = GeneralResponse
                .<String>builder()
                .data("Saving successfully!")
                .message("All suppliers are saving successfully!")
                .status(HttpStatus.CONTINUE)
                .build();

        when(supplierService.save(request)).thenReturn(expectedResponse);

        GeneralResponse<String> result = supplierController.save(request);

        assertEquals(expectedResponse.getData(), result.getData());
        assertEquals(expectedResponse.getMessage(), result.getMessage());
        assertEquals(expectedResponse.getStatus(), result.getStatus());
    }}

