package com.dtproject.dao.daoImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtproject.dao.ProductDao;
import com.dtproject.model.Category;
import com.dtproject.model.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Category category=(Category) session.get(Category.class, product.getCategory().getcId());
		product.setCategory(category);
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully inserted data");
	}
		
	@Override
	public List<Product> getAllProduct()
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("From Product");
		List<Product> productList=query.list();
		session.close();
		
		return productList;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
