package com.upoint.propertyatomic.app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.upoint.dto.property.PropertyDto;
import com.upoint.dto.property.UpdatePropertyDto;
import com.upoint.model.product.Property;
import com.upoint.propertyatomic.exception.EntityNotFoundException;
import com.upoint.propertyatomic.util.Message;
import com.upoint.utilities.mapper.Mapper;

@Service
public class PropertyService {
	private static final Logger LOG = LoggerFactory.getLogger(PropertyService.class);
	
	@Autowired
	private Message  message;
	
	@Autowired 
	private PropertyRepository repository;
	
	@Autowired
	@Qualifier("propertyMapper")
	private Mapper<PropertyDto, Property> propertyMapper;
	
	public Integer save(PropertyDto dto) {
		Property property = propertyMapper.mapFrom(dto);
		Property saved = repository.save(property);
		LOG.info("property entity saved with id:" + saved.getId());
		return saved.getId();
	}
	
	public String delete(Integer propertyId) throws EntityNotFoundException {
		Optional<Property> result = repository.findById(propertyId);
		if(result.isPresent()) {
			repository.delete(result.get());
			return message.getPropertyDeleted(propertyId);
		} else {
			throw new EntityNotFoundException(message.getEntityNotFound(propertyId));
		}
	}
	
	public PropertyDto getPropertyById(Integer propertyId) throws EntityNotFoundException {
		Optional<Property> result = repository.findById(propertyId);
		if(result.isPresent()) {
			return propertyMapper.mapTo(result.get());
		} else {
			throw new EntityNotFoundException(message.getEntityNotFound(propertyId));
		}
	}
	 
	public String update(UpdatePropertyDto dto) throws EntityNotFoundException {
		Optional<Property> result = repository.findById(dto.getPropertyid());
		if(result.isPresent()) {
			Property property = result.get();
			property.setName(dto.getPropertyName());
			property.setAvailableUnits(dto.getPropertyAvaliableUnits());
			repository.update(property);
			return message.getPropertyUpdated(dto.getPropertyid());
		} else {
			throw new EntityNotFoundException(message.getEntityNotFound(dto.getPropertyid()));
		}
	}
	
 }
