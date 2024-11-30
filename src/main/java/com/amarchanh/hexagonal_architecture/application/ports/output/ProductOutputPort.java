package com.amarchanh.hexagonal_architecture.application.ports.output;

import com.amarchanh.hexagonal_architecture.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);
}
