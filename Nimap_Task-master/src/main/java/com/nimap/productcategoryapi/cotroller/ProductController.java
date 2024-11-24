package com.nimap.productcategoryapi.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.productcategoryapi.model.Product;
import com.nimap.productcategoryapi.response.ProductResponse;
import com.nimap.productcategoryapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Get all products with pagination
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
		Page<Product> products = productService.getAllProducts(pageable);
		return ResponseEntity.ok(products);
	}

	/*// Get product by ID including associated category
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
	    Product product = productService.getProductById(id);
	    ProductResponse response = new ProductResponse();
	    response.setId(product.getId());
	    response.setName(product.getName());
	    response.setPrice(product.getPrice());
	    response.setCategory(product.getCategory()); // Include the category details

	    return ResponseEntity.ok(response);
	}

	
	 

	/*// Create new product
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.createProduct(product);
		return ResponseEntity.ok(createdProduct);
	}*/
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	    // Ensure category is set before saving
	    if (product.getCategory() == null || product.getCategory().getId() == null) {
	        throw new RuntimeException("Product must have a valid category");
	    }
	    Product createdProduct = productService.createProduct(product);
	    return ResponseEntity.ok(createdProduct);
	}

	// Update product by ID
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product updatedProduct = productService.updateProduct(id, productDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	// Delete product by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
