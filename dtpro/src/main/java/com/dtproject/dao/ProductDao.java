package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Product;

public interface ProductDao 
{
	void saveProduct(Product product);
	
	List<Product> getAllProducts();

	List<Product> getAllProduct();

}
