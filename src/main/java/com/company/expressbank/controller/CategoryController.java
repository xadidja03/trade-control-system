package com.company.expressbank.controller;

import com.company.expressbank.model.dto.request.CategoryDtoRequest;
import com.company.expressbank.model.dto.response.CategoryDtoResponse;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/commerce/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/registration")
    public GeneralResponse<String> save(@RequestBody @Valid CategoryDtoRequest categoryDtoRequest) {
        log.info("request -> {}",categoryDtoRequest);
        return categoryService.save(categoryDtoRequest);
    }

    @GetMapping("/showing")
    public GeneralResponse<List<CategoryDtoResponse>> getCategories() {
        GeneralResponse<List<CategoryDtoResponse>> findAll = categoryService.findAll();
        log.info("{}",findAll);
        return findAll;
    }
}