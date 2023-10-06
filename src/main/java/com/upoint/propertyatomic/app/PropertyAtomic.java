package com.upoint.propertyatomic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.upoint.dto.property.PropertyDto;
import com.upoint.dto.property.UpdatePropertyDto;
import com.upoint.propertyatomic.exception.EntityNotFoundException;


@RestController
@RequestMapping("/property")
public class PropertyAtomic {
	
	@Autowired
	private PropertyService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody PropertyDto property) {
		Integer saved = service.save(property);
		return saved;
	}
	
	@DeleteMapping(value = "/{propertyId}")
	public ResponseEntity<String> delete(@PathVariable Integer propertyId) throws EntityNotFoundException {
		return new ResponseEntity<> (service.delete(propertyId), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{propertyId}")
	public PropertyDto getPropertyById(@PathVariable Integer propertyId) throws EntityNotFoundException {
		return service.getPropertyById(propertyId);
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody UpdatePropertyDto property) throws EntityNotFoundException {
		return service.update(property);
	}

}
