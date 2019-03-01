package com.petClinic.demo.service;

import java.util.Set;

public interface CrudService <T, ID> {
	
	public void deleteById(ID id);
	public T save(T object);
	public T findById(ID id);
	public Set <T> findAll();
	public void delete(T object);

}
