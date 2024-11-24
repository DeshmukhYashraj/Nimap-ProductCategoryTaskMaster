package com.nimap.productcategoryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.productcategoryapi.model.Category;
import com.nimap.productcategoryapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	// for manage pagination 
	public Page<Category> getAllCategories(Pageable pageable){
		return categoryRepository.findAll(pageable);
	}
	
	//finds category from its id
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category Not Found"));
	}
	
	//for create the Category
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	//for update the Category
	public Category updateCategory(Long id, Category categoryDetails) {
		Category category = getCategoryById(id);
		category.setName(categoryDetails.getName());
		return categoryRepository.save(category);
	}
	
	//for delete the category
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
