package com.petClinic.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petClinic.demo.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

}
