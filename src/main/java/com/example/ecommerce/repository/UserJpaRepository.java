package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Users;

@Repository
public interface UserJpaRepository extends JpaRepository<Users,Integer>{
    
    Users findByUsername(String username);
}
