package com.amarchanh.hexagonal_architecture.application.ports.input;

import com.amarchanh.hexagonal_architecture.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}
