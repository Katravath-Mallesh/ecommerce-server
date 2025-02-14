package com.example.ecommerce.repository;
import com.example.ecommerce.model.Product;
import java.util.*;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProduct(int id);
    List<Product> getProductsByTitle(String title);
   
}
