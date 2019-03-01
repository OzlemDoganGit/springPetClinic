package com.petClinic.demo.service;

import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Pet;
@Service
@Qualifier("petServiceMap")
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
	
	Logger logger = Logger.getLogger(PetServiceMap.class.getName());
	

	public PetServiceMap() {
	}
	
	public void deleteById(Long id)
	{
		super.deleteByID(id);
	}
	public Pet save(Pet pet) {
		logger.info("Emre PetServiceMap "+ pet.getName());
		return super.save(pet);
		
	}
	public Pet findById(Long id) {
		return super.findById(id);
		
	}
	public Set <Pet> findAll(){
		return super.findAll();
		
	}
	public void delete(Pet object) {
		super.delete(object);
	}
}
