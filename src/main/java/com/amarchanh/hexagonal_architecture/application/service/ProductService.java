package com.amarchanh.hexagonal_architecture.application.service;

import com.amarchanh.hexagonal_architecture.application.ports.input.CreateProductUseCase;
import com.amarchanh.hexagonal_architecture.application.ports.input.GetProductUseCase;
import com.amarchanh.hexagonal_architecture.application.ports.output.ProductEventPublisher;
import com.amarchanh.hexagonal_architecture.application.ports.output.ProductOutputPort;
import com.amarchanh.hexagonal_architecture.domain.event.ProductCreatedEvent;
import com.amarchanh.hexagonal_architecture.domain.exception.ProductNotFound;
import com.amarchanh.hexagonal_architecture.domain.model.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = this.productOutputPort.saveProduct(product);
        this.productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(final Long id) {
        return this.productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

}
