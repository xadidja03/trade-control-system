package com.company.expressbank.service.impl;

import com.company.expressbank.exception.ApplicationException;
import com.company.expressbank.mapper.CategoryMapper;
import com.company.expressbank.model.constants.Constants;
import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.CategoryDtoResponse;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.entity.Category;
import com.company.expressbank.model.enums.Exceptions;
import com.company.expressbank.repository.CategoryRepository;
import com.company.expressbank.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public GeneralResponse<String> save(CategoryDtoRequest categoryDtoRequest) {
        Category category = categoryMapper.
                categoryRequestDtoToCategory(categoryDtoRequest);
        categoryRepository.save(category);
        return GeneralResponse.of(Constants.CREATED_SUCCESSFULLY, HttpStatus.CREATED
                );

    }

    @Override
    public GeneralResponse<List<CategoryDtoResponse>> findAll() {
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new ApplicationException(Exceptions.CATEGORY_NOT_FOUND);
        }

        List<CategoryDtoResponse> categoryDtoResponses = categoryMapper.categoryListToCategoryResponseList(categories);

        return GeneralResponse.of(categoryDtoResponses, HttpStatus.ACCEPTED, Constants.SHOW_SUCCESSFULLY);
    }

}
