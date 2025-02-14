package com.example.ecommerce.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.PrimeProduct;

@Repository
public interface PrimeProductJpaRepository extends JpaRepository<PrimeProduct,Integer>{

   
}