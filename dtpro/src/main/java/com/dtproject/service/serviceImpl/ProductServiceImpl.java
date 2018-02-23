package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.ProductDao;
import com.dtproject.model.Product;
import com.dtproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void saveProduct(Product product){
		productDao.saveProduct(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product>productList=productDao.getAllProducts();
		
		return productList;
	}
	
	

}
