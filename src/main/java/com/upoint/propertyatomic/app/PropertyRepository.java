package com.upoint.propertyatomic.app;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upoint.model.product.Property;

public interface PropertyRepository  extends JpaRepository<Property, Integer>, ExtendedPropertyRepository {
	
}
