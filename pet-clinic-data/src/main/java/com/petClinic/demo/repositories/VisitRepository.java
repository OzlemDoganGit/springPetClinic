package com.petClinic.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petClinic.demo.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
