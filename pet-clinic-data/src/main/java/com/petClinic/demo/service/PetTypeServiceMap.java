package com.petClinic.demo.service;

import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.PetType;

@Service
@Qualifier("petTypeServiceMap")
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	Logger logger = Logger.getLogger(PetTypeServiceMap.class.getName());
	
	public PetTypeServiceMap() {
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);

	}

	@Override
	public PetType save(PetType object) {
		logger.info("EMRE PetTypeService "+object.getName());
		return super.save(object);
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);

	}

}
