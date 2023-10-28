package com.company.expressbank.mapper;
import com.company.expressbank.model.dto.request.ProductDtoRequest;
import com.company.expressbank.model.dto.response.ProductDtoResponse;
import com.company.expressbank.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "categoryId",target = "category.id")
    @Mapping(source = "supplierId",target = "supplier.id")
    @Mapping(target = "id",ignore = true)
    Product productRequestDtoToProduct(ProductDtoRequest productDtoRequest);

    ProductDtoResponse productToProductDtoResponse(Product product);

    List<ProductDtoResponse> productListToProductResponseList(List<Product> products);


}