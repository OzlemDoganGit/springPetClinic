package com.petClinic.demo.controller;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.petClinic.demo.model.Owner;
import com.petClinic.demo.model.Pet;
import com.petClinic.demo.service.OwnerService;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OwnerIndexControllerTest {
	@Mock
	OwnerService ownerService;
	@InjectMocks
	OwnerIndexController ownerIndexController;
	
	Set <Owner> ownerSet;
	
	private final Long ownerId = 1L;
	private final Long secondOwnerId = 2L;
	
	Owner owner;
	Owner secondOwner;
	private Set<Pet> pets = new HashSet<>();
	
	MockMvc mockMvc;
	

	@BeforeEach
	void setUp() throws Exception {
		
		ownerSet = new HashSet<Owner>();
		owner = new Owner(ownerId, "SİSLİ", "İSTANBUL", "0212102102", pets, "EMRE", "DOGAN");
		secondOwner = new Owner(secondOwnerId, "SİSLİ", "İSTANBUL", "0212102102", pets, "OZLEM", "DOGAN");
		ownerSet.add(owner);
		ownerSet.add(secondOwner);
		mockMvc = MockMvcBuilders.standaloneSetup(ownerIndexController).build();
		
	}

	@Test
	void testOwnerIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(ownerSet);
		mockMvc.perform(get("/owners/index")).andExpect(status().isOk())
		.andExpect(view().name("owner/index"))
		.andExpect(model().attribute("owners", hasSize(2)));
		
	}

	@Test
	void testFind() throws Exception {
		
		mockMvc.perform(get("/owners/find")).andExpect(status().is2xxSuccessful())
		.andExpect(view().name("notImplemented"));
		
		verifyZeroInteractions(ownerService);
		
	}

}
