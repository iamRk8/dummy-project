package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Supplier;

public interface SupplierDao {
	
	List<Supplier> getAllSuppliers();
	
	void saveSupplier(Supplier supplier, int pId);

}
