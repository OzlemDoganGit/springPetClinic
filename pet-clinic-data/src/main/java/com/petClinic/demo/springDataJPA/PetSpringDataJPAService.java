package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Pet;
import com.petClinic.demo.repositories.OwnerRepository;
import com.petClinic.demo.repositories.PetRepository;
import com.petClinic.demo.service.PetService;
import com.petClinic.demo.service.PetServiceMap;

@Service
@Profile ("springdatajpa")
public class PetSpringDataJPAService implements PetService {
	
	Logger logger = Logger.getLogger(PetSpringDataJPAService.class.getName());
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	
	public PetSpringDataJPAService(PetRepository petRepository, OwnerRepository ownerRepository) {
		this.petRepository = petRepository;
		this.ownerRepository = ownerRepository;
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	@Override
	public Pet save(Pet object) {
		logger.log(Level.INFO, "Pet is saved with the help of Spring Data JPA implementeation");

		return petRepository.save(object);
	}

	@Override
	public Pet findById(Long id) {	
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Pet> findAll() {
		Set <Pet> petSet = new HashSet<>();
		petRepository.findAll().forEach(petSet::add);
		return petSet;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

}
