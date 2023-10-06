package com.upoint.propertyatomic.app;

import org.springframework.beans.factory.annotation.Autowired;
import com.upoint.model.product.Property;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ExtendedPropertyRepositoryImpl implements ExtendedPropertyRepository{
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(property);
		manager.getTransaction().commit();
		manager.close();
		
	}
  
}
