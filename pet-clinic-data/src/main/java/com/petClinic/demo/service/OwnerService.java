package com.petClinic.demo.service;

import com.petClinic.demo.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	


}
