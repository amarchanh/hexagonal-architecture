package com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql;

import com.amarchanh.hexagonal_architecture.application.ports.output.ProductOutputPort;
import com.amarchanh.hexagonal_architecture.domain.model.Product;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.entity.ProductEntity;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.mapper.ProductPersistenceMapper;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(final Product product) {
        ProductEntity productEntity = this.productPersistenceMapper.toProductEntity(product);
        productEntity = this.productRepository.save(productEntity);
        return this.productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(final Long id) {
        final Optional<ProductEntity> productEntity = this.productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        final Product product = this.productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

}
