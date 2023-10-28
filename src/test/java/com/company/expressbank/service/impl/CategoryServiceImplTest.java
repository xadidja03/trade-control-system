package com.company.expressbank.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.CategoryMapper;
import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.repository.CategoryRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryMapper categoryMapper;

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    void testSave() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptops");
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setName("Smartphones");
        when(categoryMapper.categoryRequestDtoToCategory(Mockito.<CategoryDtoRequest>any())).thenReturn(category2);
        GeneralResponse<String> actualSaveResult = categoryServiceImpl.save(new CategoryDtoRequest("Laptops"));
        verify(categoryMapper).categoryRequestDtoToCategory(Mockito.<CategoryDtoRequest>any());
        verify(categoryRepository).save(Mockito.<Category>any());
        assertEquals("CREATED", actualSaveResult.getData());
        assertEquals("Creating is successfully.", actualSaveResult.getMessage());
        assertEquals(HttpStatus.CREATED, actualSaveResult.getStatus());
    }
    @Test
    void testFindAll() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(ApplicationException.class, () -> categoryServiceImpl.findAll());
        verify(categoryRepository).findAll();
    }
}

