package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
    // Custom query method to search products by title (case-insensitive)
    List<Product> findByTitleContainingIgnoreCase(String title);
}
