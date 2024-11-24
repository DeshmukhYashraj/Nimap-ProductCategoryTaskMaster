package com.nimap.productcategoryapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.productcategoryapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	//this is for the handle server side pagination
	Page<Category> findAll(Pageable pageable);
}
