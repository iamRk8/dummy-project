package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.SupplierDao;
import com.dtproject.model.Product;
import com.dtproject.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveSupplier(Supplier supplier,int pId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Product where pId="+pId);
		
		List<Product> proList=query.list();
		supplier.setProduct(proList);
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully inserted data");
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}
}
