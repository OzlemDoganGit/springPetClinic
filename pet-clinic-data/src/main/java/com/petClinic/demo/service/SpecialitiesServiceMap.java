package com.petClinic.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Speciality;

@Service
@Qualifier("specialitiesServiceMap")
@Profile({"default", "map"})
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);

	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);

	}

}
