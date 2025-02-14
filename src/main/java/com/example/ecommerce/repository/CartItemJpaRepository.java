package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.CartItem;

public interface CartItemJpaRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUserUsername(String username); // Method to find cart items by username
}
