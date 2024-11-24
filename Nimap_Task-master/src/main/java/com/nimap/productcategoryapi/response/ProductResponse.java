package com.nimap.productcategoryapi.response;

import com.nimap.productcategoryapi.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Category category; // Add category here

    // Constructor, Getters, and Setters
}
