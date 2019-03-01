package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Owner;
import com.petClinic.demo.repositories.OwnerRepository;
import com.petClinic.demo.repositories.PetRepository;
import com.petClinic.demo.service.OwnerService;
@Service
@Profile("springdatajpa")
public class OwnerSpringDataJPAService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;

	public OwnerSpringDataJPAService(OwnerRepository ownerRepository, PetRepository petRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public Owner findById(Long id) {
	
		Optional <Owner> owner = ownerRepository.findById(id);
		return  owner.get();
	}

	@Override
	public Set<Owner> findAll() {
		
		Set <Owner> ownerSet = new HashSet<Owner>();
		ownerRepository.findAll().forEach(ownerSet::add);
		return ownerSet;
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);

	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
