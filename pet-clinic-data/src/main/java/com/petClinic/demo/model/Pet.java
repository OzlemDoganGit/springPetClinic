package com.petClinic.demo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;

@Entity
@Table(name="pet")
public class Pet extends BaseEntity{

	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="pet")
	private Set <Visit> visits = new HashSet<Visit>();
	
	@NotEmpty
	@Column(name="name")
	private String name;

	
	
public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*

	public Pet(Long id, LocalDate birthDate, PetType petType, Owner owner, String name,
			Set<Visit> visits) {
		super(id);
		this.birthDate = birthDate;
		this.petType = petType;
		this.owner = owner;
		this.name = name;
		
		if (visits == null)
		{
			this.visits = visits;
		}
		
	}
*/
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [birthDate=" + birthDate + ", owner=" + owner + "]";
	}

	public Set<Visit> getVisit() {
		return visits;
	}

	public void setVisit(Set<Visit> visits) {
		this.visits = visits;
	}
		
	

}
