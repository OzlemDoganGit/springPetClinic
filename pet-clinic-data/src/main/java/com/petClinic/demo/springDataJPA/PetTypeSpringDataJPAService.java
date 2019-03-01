package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.PetType;
import com.petClinic.demo.repositories.PetTypeRepository;
import com.petClinic.demo.service.PetTypeService;

@Service
@Profile ("springdatajpa")
public class PetTypeSpringDataJPAService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;
	
	public PetTypeSpringDataJPAService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);

	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set <PetType> petTypeSet = new HashSet<PetType>();
		petTypeRepository.findAll().forEach(petTypeSet::add);
		return petTypeSet;
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

}
