package com.company.expressbank.controller;

import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.request.ProductUpdateDtoRequest;
import com.company.expressbank.model.dto.response.GeneralResponse;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import com.company.expressbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/commerce/products")
public class ProductController {
    private final ProductService productService;


    @PostMapping("/registration")
    public GeneralResponse<String > save(@RequestBody @Valid ProductDtoRequest productDtoRequest) {
        log.info("request -> {}",productDtoRequest);
        return productService.save(productDtoRequest);
    }
    @GetMapping("/showing")
    public GeneralResponse<List<ProductDtoResponse>> getAllProduct(){
        GeneralResponse<List<ProductDtoResponse>> getAllProducts = productService.findAll();
        log.info("{}",getAllProducts);
        return getAllProducts;
    }
    @PutMapping("/{id}")
    public GeneralResponse<ProductDtoResponse> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductUpdateDtoRequest productDtoRequest){
        GeneralResponse<ProductDtoResponse> update = productService.update(id,productDtoRequest);
        log.info("{}-> request, {} id",update,id);
        return update;

    }
    @GetMapping("/{id}")
    public GeneralResponse<ProductDtoResponse> findByIdProduct(@PathVariable Long id){
        GeneralResponse<ProductDtoResponse> findById = productService.findById(id);
        log.info("{}-> request, {} id",findById,id);
        return findById;

    }

    @DeleteMapping("{id}")
    public GeneralResponse<ProductDtoResponse> deleteProduct(@PathVariable Long id){
        GeneralResponse<ProductDtoResponse> delete= productService.delete(id);
        log.info(" {} id",id);
        return  delete;
    }



}


