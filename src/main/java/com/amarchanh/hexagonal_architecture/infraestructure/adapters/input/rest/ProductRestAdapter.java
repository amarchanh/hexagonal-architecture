package com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest;

import com.amarchanh.hexagonal_architecture.application.ports.input.CreateProductUseCase;
import com.amarchanh.hexagonal_architecture.application.ports.input.GetProductUseCase;
import com.amarchanh.hexagonal_architecture.domain.model.Product;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.response.ProductCreateResponse;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.response.ProductQueryResponse;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.mapper.ProductRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final ProductRestMapper productRestMapper;

    @PostMapping(value = "/products")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid final ProductCreateRequest productCreateRequest){
        // Request to domain
        Product product = this.productRestMapper.toProduct(productCreateRequest);

        product = this.createProductUseCase.createProduct(product);

        // Domain to response
        return new ResponseEntity<>(this.productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable final Long id){
        final Product product = this.getProductUseCase.getProductById(id);
        return new ResponseEntity<>(this.productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

}
