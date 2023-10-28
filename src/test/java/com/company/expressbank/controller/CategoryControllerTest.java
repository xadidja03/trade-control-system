package com.company.expressbank.controller;

import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.CategoryDtoResponse;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CategoryController.class})
@ExtendWith(SpringExtension.class)
class CategoryControllerTest {

    @MockBean
    private CategoryService categoryService;

    @Test
    void testGetCategories() {
        when(categoryService.findAll()).thenReturn(
                GeneralResponse.<List<CategoryDtoResponse>>builder()
                        .data(new ArrayList<>())
                        .message("All categories are getting successfully!")
                        .status(HttpStatus.CONTINUE)
                        .timeStamp(LocalDate.of(2022, 11, 4).atStartOfDay())
                        .build()
        );

        CategoryController categoryController = new CategoryController(categoryService);

        GeneralResponse<List<CategoryDtoResponse>> response = categoryController.getCategories();

        assertEquals("All categories are getting successfully!", response.getMessage());
        assertEquals(HttpStatus.CONTINUE, response.getStatus());
        assertEquals(LocalDate.of(2022, 11, 4).atStartOfDay(), response.getTimeStamp());
        assertEquals(0, response.getData().size());
    }

    @Test
    void testSave() {
        when(categoryService.save(Mockito.any())).thenReturn(
                GeneralResponse.<String>builder()
                        .data("Creating succesfully!")
                        .message("All categories are saving successfully!")
                        .status(HttpStatus.CONTINUE)
                        .timeStamp(LocalDate.of(2022, 11, 4).atStartOfDay())
                        .build()
        );

        CategoryDtoRequest categoryDtoRequest = new CategoryDtoRequest();
        categoryDtoRequest.setName("smartphones");

        CategoryController categoryController = new CategoryController(categoryService);

        GeneralResponse<String> response = categoryController.save(categoryDtoRequest);

        assertEquals("All categories are saving successfully!", response.getMessage());
        assertEquals(HttpStatus.CONTINUE, response.getStatus());
        assertEquals(LocalDate.of(2022, 11, 4).atStartOfDay(), response.getTimeStamp());
    }
}
