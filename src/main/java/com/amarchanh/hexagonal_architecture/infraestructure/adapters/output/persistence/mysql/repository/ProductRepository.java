package com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.repository;

import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.persistence.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}

