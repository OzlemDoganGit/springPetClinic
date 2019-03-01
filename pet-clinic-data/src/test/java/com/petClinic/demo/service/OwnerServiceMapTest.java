package com.petClinic.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petClinic.demo.model.Owner;
import com.petClinic.demo.model.Pet;

class OwnerServiceMapTest {
	
	private OwnerServiceMap ownerServiceMap;
	
	final Long ownerId = 1L;
	final String lastName = "DOGAN";
	@BeforeEach
	void setUp() throws Exception {
		
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap() );
		Set <Pet> pets = new HashSet<>();
		Owner owner = new Owner(ownerId, "SİSLİ", "İSTANBUL", "0212102102", pets, "OZLEM",
				"DOGAN");
		ownerServiceMap.save(owner);
	}

	@Test
	void testDeleteById() {
		ownerServiceMap.deleteByID(ownerId);
		Set <Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(0, ownerSet.size());
	}

	@Test
	void testSaveOwner() {
		Long tempOwnerId = 2L;
		Set <Pet> pets = new HashSet<>();
		Owner owner = new Owner(tempOwnerId, "FERIKOY", "İSTANBUL", "0212102102", pets, "EMRE",
				"DOGAN");
		Owner savedOwner = ownerServiceMap.save(owner);
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
		assertEquals(tempOwnerId, savedOwner.getId());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testFindAll() {
		Set <Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testDeleteOwner() {
		
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		Set <Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(0, ownerSet.size());
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerServiceMap.findByLastName(lastName);
		assertEquals(lastName, owner.getLastName());
		assertNotNull(owner);
	}

}
