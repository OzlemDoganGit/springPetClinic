package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Vet;
import com.petClinic.demo.repositories.VetRepository;
import com.petClinic.demo.service.VetService;

@Service
@Profile ("springdatajpa")
public class VetSpringDataJPAService implements VetService {
	
	private final VetRepository vetRepository;	

	public VetSpringDataJPAService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Vet findById(Long id) {
		Optional <Vet> vet = vetRepository.findById(id);
		return vet.get();
	}


	@Override
	public Set<Vet> findAll() {
		Set <Vet> vetSet = new HashSet<Vet>();
		vetRepository.findAll().forEach(vetSet::add);
		return vetSet;
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

}
