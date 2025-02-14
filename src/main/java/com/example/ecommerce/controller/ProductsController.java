package com.example.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.Users;
import com.example.ecommerce.model.PrimeProduct;
import com.example.ecommerce.service.ProductJpaService;
import com.example.ecommerce.service.UserService;
import java.util.*;
import com.example.ecommerce.model.CartItem;


// import com.example.ecommerce.service.CartJpaService;

import com.example.ecommerce.service.PrimeProductJpaService;
import com.example.ecommerce.service.CartJpaService;
import com.example.ecommerce.service.JWTService;

import org.springframework.http.ResponseEntity;




// @CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductsController {
    @Autowired
    private ProductJpaService productJpaService;

    @Autowired
    private PrimeProductJpaService primeProductJpaService;

    @Autowired
    private UserService userService;


    @Autowired
    private JWTService jwtService;

   

    @Autowired
    private CartJpaService cartJpaService;

    
   
   
    @GetMapping("/products")
    public Map<String, List<Product>> getProducts(@RequestParam(value = "title_search", required = false) String titleSearch) {
        List<Product> products;
        
        if (titleSearch != null && !titleSearch.isEmpty()) {
            // If a search query is provided, filter the products
            products = productJpaService.getProductsByTitle(titleSearch);
        } else {
            // If no search query, return all products
            products = productJpaService.getProducts();
        }

        Map<String, List<Product>> response = new HashMap<>();
        response.put("products", products);  // Wrapping in "products" key
        return response;
    }
    
    @GetMapping("/prime_deals")
    
    public Map<String, List<PrimeProduct>> getPrimeProducts()
    {
        List<PrimeProduct> products = primeProductJpaService.getPrimeProducts();
        Map<String, List<PrimeProduct>> response = new HashMap<>();
        response.put("products", products);  // Wrapping in "products" key
        return response;
    }
    @GetMapping("/products/{id}")
   
    public Product getProduct(@PathVariable("id") int id)
    {
        return productJpaService.getProduct(id);
    }
    
   
  

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>>  login(@RequestBody Users user) {
        return userService.verify(user); 
    }
    

@PostMapping("/register")
public Users register(@RequestBody Users user)
{
    return userService.register(user);
} 





@PostMapping("/order")
public ResponseEntity<Map<String, Object>> placeOrder(
        @RequestHeader("Authorization") String authHeader,
        @RequestBody List<CartItem> cartItems) {

    try {

        System.out.println("Received Cart Items: " + cartItems.get(0));

        // Extract token and username
        String token = authHeader.substring(7); // Remove "Bearer " prefix
        String username = jwtService.extractUserName(token);

        // Call the service to save the order
        cartJpaService.placeOrder(username, cartItems);

        // Prepare the success response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Order placed successfully!");
        response.put("username", username);
        response.put("cartItems", cartItems);

        return ResponseEntity.ok(response);

    } catch (Exception e) {
        // Prepare the error response
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", "error");
        errorResponse.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(errorResponse);
    }
}




   
}
