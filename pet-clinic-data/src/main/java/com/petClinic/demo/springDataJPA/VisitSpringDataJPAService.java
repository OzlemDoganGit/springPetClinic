package com.petClinic.demo.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Visit;
import com.petClinic.demo.repositories.VisitRepository;
import com.petClinic.demo.service.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJPAService implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitSpringDataJPAService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		Set <Visit> visitSet = new HashSet<Visit>();
		visitRepository.findAll().forEach(visitSet::add);
		return visitSet;
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

}
