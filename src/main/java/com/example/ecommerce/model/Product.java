package com.example.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating")
    private double rating;
    @Column(name="availability")
    private String availability;

    @Column(name="description")
    private String description;

    @Column(name="totalReviews")
    private int totalReviews;

    // Constructor
    public Product(){}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getAvailability() {
        return availability;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

   
    
}
