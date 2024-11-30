package com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.mapper;

import com.amarchanh.hexagonal_architecture.domain.model.Product;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.response.ProductCreateResponse;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.response.ProductQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);

}

