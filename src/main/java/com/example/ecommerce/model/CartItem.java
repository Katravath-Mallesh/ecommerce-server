package com.example.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Unique ID for the CartItem
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;  // Foreign key to associate cart items with a specific user (reference to User entity)

    @Column(name = "product_id")
    private int productId;  // Foreign key to the product in the cart

    @Column(name = "title")
    private String title;  // Name of the product

    @Column(name = "quantity")
    private int quantity;  // Quantity of the product

    @Column(name = "price")
    private double price;  // Price of the product per unit

    
    // Default constructor
    public CartItem() {}

    // Parameterized constructor
    public CartItem(Users user, int productId, String title, int quantity, double price) {
        this.user = user;
        this.productId = productId;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
