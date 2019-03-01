package com.petClinic.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petClinic.demo.model.Visit;

@Service
@Qualifier("visitServiceMap")
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);

	}

	@Override
	public Visit save(Visit object) {
		if (object.getPet() == null || object.getPet().getOwner() == null
				|| object.getPet().getId() == null || object.getPet().getOwner().getId() == null)
		{
			throw new RuntimeException("Visit is invalid");
		}
		return super.save(object);
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);

	}

}
