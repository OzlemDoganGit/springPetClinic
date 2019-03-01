package com.petClinic.demo.springDataJPA;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.petClinic.demo.model.Owner;
import com.petClinic.demo.model.Pet;
import com.petClinic.demo.repositories.OwnerRepository;
import com.petClinic.demo.repositories.PetRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJPAServiceTest {

	@InjectMocks
	private OwnerSpringDataJPAService ownerSpringDataJPA;
	@Mock
	private OwnerRepository ownerRepository;
	@Mock
	private PetRepository petRepository;

	private final Long ownerId = 1L;
	private final Long secondOwnerId = 2L;

	private final String lastName = "DOGAN";

	private Owner owner;
	private Owner secondOwner;

	private Set<Pet> pets = new HashSet<>();

	private Set<Owner> ownerSet = new HashSet<Owner>();

	@BeforeEach
	void setUp() throws Exception {
		owner = new Owner(ownerId, "SİSLİ", "İSTANBUL", "0212102102", pets, "EMRE", "DOGAN");
		secondOwner = new Owner(secondOwnerId, "SİSLİ", "İSTANBUL", "0212102102", pets, "OZLEM", "DOGAN");
	}

	@Test
	void testDeleteById() {
		ownerSpringDataJPA.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testSave() {
		
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSpringDataJPA.save(owner);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
		Owner savedOwner = ownerSpringDataJPA.findById(ownerId);
		assertNotNull(savedOwner);
		assertEquals(ownerId, savedOwner.getId());
	}

	@Test
	void testFindAll() {

		ownerSet.add(owner);
		ownerSet.add(secondOwner);
		when(ownerRepository.findAll()).thenReturn(ownerSet);
		Set<Owner> owners = ownerSpringDataJPA.findAll();
		assertNotNull(owners);
		assertEquals(2, owners.size());
		verify(ownerRepository).findAll();

	}

	@Test
	void testDelete() {

		ownerSpringDataJPA.delete(owner);
        //default is 1 times
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(owner);
		Owner savedOwner = ownerSpringDataJPA.findByLastName(lastName);
		assertEquals(lastName, owner.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

}
