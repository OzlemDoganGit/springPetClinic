package com.petClinic.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name ="vets")
public class Vet extends Person {

	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="vet_specialities", joinColumns= @JoinColumn(name="vet_id"),
	inverseJoinColumns=@JoinColumn(name="speciality_id"))
	Set <Speciality> spec = new HashSet<Speciality>();
	
	
	
	public Vet() {

	}

	/*
	public Vet(Long id, String firstName, String lastName, Set<Speciality> spec) {
		super(id, firstName,lastName);
		if (spec == null)
		{
			this.spec = spec;
		}	
	}
*/
	public Set<Speciality> getSpec() {
		return spec;
	}

	public void setSpec(Set<Speciality> spec) {
		this.spec = spec;
	}

	
	
	
	
	
}
