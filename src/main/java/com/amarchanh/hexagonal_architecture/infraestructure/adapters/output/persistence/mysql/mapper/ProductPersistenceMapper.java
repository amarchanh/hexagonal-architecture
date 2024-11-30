package com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.mapper;

import com.amarchanh.hexagonal_architecture.domain.model.Product;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
