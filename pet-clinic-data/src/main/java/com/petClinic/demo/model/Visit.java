package com.petClinic.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity{
	
	//@NotEmpty
	@Column(name="date")
	private LocalDate date;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	

	public Visit() {

	}

	/*
	public Visit(Long id, LocalDate date, String description) {
		super(id);
		this.date = date;
		this.description = description;
	}
*/
	public Visit(LocalDate now, String string) {
		this.date = now;
		this.description = string;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	

}
