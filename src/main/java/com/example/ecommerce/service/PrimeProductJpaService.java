package com.example.ecommerce.service;
import com.example.ecommerce.repository.PrimeProductJpaRepository;
import com.example.ecommerce.repository.PrimeProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.ecommerce.model.PrimeProduct;

@Service
public class PrimeProductJpaService implements PrimeProductRepository{

    @Autowired
    PrimeProductJpaRepository primeProductJpaRepository;

    @Override
    public ArrayList<PrimeProduct> getPrimeProducts() {
       try {
        return (ArrayList<PrimeProduct>) primeProductJpaRepository.findAll();
       } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }


}