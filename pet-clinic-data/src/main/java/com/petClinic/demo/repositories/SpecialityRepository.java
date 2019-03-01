package com.petClinic.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petClinic.demo.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
