package com.petClinic.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {
	
	@NotEmpty
	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="vet_specialities", joinColumns= @JoinColumn(name="speciality_id"),
	inverseJoinColumns=@JoinColumn(name="vet_id"))
	Set <Vet> vets = new HashSet<Vet>();

	
public Speciality() {
	}

	/*
	public Speciality(Long id, String description, Set<Vet> vets) {
		super(id);
		this.description = description;
		if(vets == null)
		{
			this.vets = vets;
		}
	}
*/
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Vet> getVets() {
		return vets;
	}

	public void setVets(Set<Vet> vets) {
		this.vets = vets;
	}

}
