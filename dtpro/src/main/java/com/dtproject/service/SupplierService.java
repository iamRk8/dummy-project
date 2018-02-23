package com.dtproject.service;

import java.util.List;

import com.dtproject.model.Supplier;

public interface SupplierService {

	List<Supplier> getAllSuppliers();
	
	void saveSupplier(Supplier supplier, int pId);
	
}
