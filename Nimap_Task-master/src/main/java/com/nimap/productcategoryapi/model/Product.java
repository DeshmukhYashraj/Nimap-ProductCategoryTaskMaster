package com.nimap.productcategoryapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "category_id")
//	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonBackReference // This indicates the "child" side of the relationship
    private Category category;
}
