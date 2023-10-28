package com.company.expressbank.mapper;

import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.CategoryDtoResponse;
import com.company.expressbank.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id",ignore = true)
    Category categoryRequestDtoToCategory(CategoryDtoRequest categoryDtoRequest);
    CategoryDtoResponse categoryToCategoryDtoResponse(Category category);
    List<CategoryDtoResponse> categoryListToCategoryResponseList(List<Category> categoryList);

}