package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.SupplierDao;
import com.dtproject.model.Supplier;
import com.dtproject.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	
	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public void saveSupplier(Supplier supplier,int pId){
		supplierDao.saveSupplier(supplier, pId);
	}
	
	@Override
	public List<Supplier>getAllSuppliers()
	{
		List<Supplier> supList=(List<Supplier>)supplierDao.getAllSuppliers();
		return supList;
	}
}
