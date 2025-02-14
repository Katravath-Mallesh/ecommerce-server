package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductJpaRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> getProducts() {
        try {
            return productJpaRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Products not found");
        }
    }

    // New method to get products by title
    public List<Product> getProductsByTitle(String title) {
        try {
            return productJpaRepository.findByTitleContainingIgnoreCase(title);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found for the search query");
        }
    }

    @Override
    public Product getProduct(int id) {
      try{
        return productJpaRepository.findById(id).get();
      }catch(Exception e){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
      }
                
    }
}
