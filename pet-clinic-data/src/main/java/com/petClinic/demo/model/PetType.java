package com.petClinic.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
@Entity
@Table(name ="types") 
public class PetType extends BaseEntity{

	@Column(name ="name")
	private String name;
	
	@OneToMany(mappedBy="petType")
	private Set <Pet> pets = new HashSet<Pet>();

	
public PetType() {
	}

	/*
	public PetType(Long id, String name, Set<Pet> pets) {
		super(id);
		this.name = name;
		
		if (pets == null)
		{
			this.pets = pets;
		}
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PetType [name=" + name + "]";
	}
	
	
}
