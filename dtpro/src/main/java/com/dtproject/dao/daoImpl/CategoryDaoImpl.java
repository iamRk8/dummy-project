package com.dtproject.dao.daoImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CategoryDao;
import com.dtproject.model.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao
{
     @Autowired
     SessionFactory sessionFactory;
     public void saveCategory(Category category)
 	{
 	Session session=sessionFactory.openSession();
 	session.beginTransaction();
 	session.save(category);
 	session.getTransaction().commit();
 	session.close();
 	System.out.println("successfully inserted data");
 	}
     
	@Override
	public List<Category> getAllCategories()
	{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("FROM Category");
	@SuppressWarnings("unchecked")
	List<Category> catList=query.list();
	session.close();
	return catList;
	}

}
