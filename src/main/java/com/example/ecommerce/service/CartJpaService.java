package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.repository.CartItemJpaRepository;
import com.example.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.model.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartJpaService {

    @Autowired
    private CartItemJpaRepository cartItemJpaRepository;


    @Autowired
    private UserService userService;

   
    


    public void placeOrder(String userName, List<CartItem> cartItems) {

        Users user=userService.findByUsername(userName);
       


        for (CartItem item : cartItems) {
            item.setUser(user); // Set username for each item
            cartItemJpaRepository.save(item);
        }
    }

    // public List<OrderItem> getOrdersByUsername(String username) {
    //     return orderItemRepository.findByUsername(username);
    // }
}
