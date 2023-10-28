package com.company.expressbank.service;

import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.CategoryDtoResponse;
import com.company.expressbank.model.dto.response.GeneralResponse;
import java.util.List;
public interface CategoryService {
    GeneralResponse<String> save(CategoryDtoRequest categoryDtoRequest);
    GeneralResponse<List<CategoryDtoResponse>> findAll();

}
