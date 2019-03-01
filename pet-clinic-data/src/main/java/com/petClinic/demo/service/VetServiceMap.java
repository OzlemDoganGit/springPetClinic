package com.petClinic.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Speciality;
import com.petClinic.demo.model.Vet;

@Service
@Qualifier("vetServiceMap")
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	private final SpecialitiesService specService;
	
	@Autowired
	public VetServiceMap(SpecialitiesService specService) {
		this.specService = specService;
	}

	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	public Vet save(Vet vet) {
		
		if (vet.getSpec().size()>1)
		{
			vet.getSpec().forEach(spec->
			{
				if (spec.getId() == null)
				{
					Speciality savedService = specService.save(spec);
					spec.setId(savedService.getId());
				}
			});
			vet.setSpec(specService.findAll());
		}
		return super.save(vet);

	}

	public Vet findById(Long id) {
		return super.findById(id);

	}

	public Set<Vet> findAll() {
		return super.findAll();

	}

	public void delete(Vet vet) {
		super.delete(vet);
	}

}
