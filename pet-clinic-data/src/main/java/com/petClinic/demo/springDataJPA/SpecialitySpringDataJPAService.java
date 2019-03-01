package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Speciality;
import com.petClinic.demo.repositories.SpecialityRepository;
import com.petClinic.demo.service.SpecialitiesService;

@Service
@Profile("springdatajpa")
public class SpecialitySpringDataJPAService implements SpecialitiesService {
	
	private final SpecialityRepository specialityRepository;	

	public SpecialitySpringDataJPAService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);

	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Speciality> findAll() {
		Set <Speciality> specialitySet = new HashSet<Speciality>();
		specialityRepository.findAll().forEach(specialitySet::add);
		return specialitySet;
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);

	}

}
