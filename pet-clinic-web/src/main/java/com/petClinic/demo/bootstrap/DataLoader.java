package com.petClinic.demo.bootstrap;

import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petClinic.demo.model.Owner;
import com.petClinic.demo.model.Pet;
import com.petClinic.demo.model.PetType;
import com.petClinic.demo.model.Speciality;
import com.petClinic.demo.model.Vet;
import com.petClinic.demo.model.Visit;
import com.petClinic.demo.service.OwnerService;
import com.petClinic.demo.service.PetService;
import com.petClinic.demo.service.PetTypeService;
import com.petClinic.demo.service.SpecialitiesService;
import com.petClinic.demo.service.VetService;
import com.petClinic.demo.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerServiceB;
	private final VetService vetServiceB;
	private final PetTypeService petTypeServiceB;
	private final SpecialitiesService specialitiesServiceB;
	private final PetService petServiceB;
	private final VisitService visitServiceB;
	
	Logger logger = Logger.getLogger(DataLoader.class.getName());

	/*
	 * public DataLoader() {
	 * 
	 * ownerService = new ownerServiceMap(); vetService = new vetServiceMap(); }
	 */
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitiesService specialitiesService, PetService petService, VisitService visitService) {
		this.ownerServiceB = ownerService;
		this.vetServiceB = vetService;
		this.petTypeServiceB = petTypeService;
		this.specialitiesServiceB = specialitiesService;
		this.petServiceB = petService;
		this.visitServiceB = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		loadData();

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType = petTypeServiceB.save(dog);
		logger.info("EMRE "+savedDogPetType);

		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedCatPetType = petTypeServiceB.save(cat);
		logger.info("EMRE "+savedCatPetType);

		Speciality radiologist = new Speciality();
		radiologist.setDescription("radiologist");
		specialitiesServiceB.save(radiologist);

		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		specialitiesServiceB.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		specialitiesServiceB.save(dentistry);
		


		Owner ozlem = new Owner();
		ozlem.setFirstName("Ozlem");
		ozlem.setLastName("Dogan");
		ozlem.setAddress("Uskudar");
		ozlem.setCity("İstanbul");
		ozlem.setTelephone("1234");
		// owner.setId(1L);
		
		Pet ozlemsPet = new Pet();
		ozlemsPet.setPetType(savedDogPetType);
		ozlemsPet.setBirthDate(LocalDate.now());
		ozlemsPet.setOwner(ozlem);
		ozlemsPet.setName("Funky");
		//Pet savedOzlemsPet = petServiceB.save(ozlemsPet);

		ozlem.getPets().add(ozlemsPet);

		ownerServiceB.save(ozlem);

		Owner fiona = new Owner();
		fiona.setFirstName("Fiona");
		fiona.setLastName("Dogan");
		fiona.setAddress("Uskudar");
		fiona.setCity("İstanbul");
		fiona.setTelephone("1234");

		// owner2.setId(2L);

		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setOwner(fiona);		
		fionasPet.setName("Shrinky");
		//Pet savedFionasPet = petServiceB.save(fionasPet);
		
		fiona.getPets().add(fionasPet);

		ownerServiceB.save(fiona);
		
		Visit catVisit = new Visit(LocalDate.now(), "cat Visit");
		catVisit.setPet(fionasPet);
		visitServiceB.save(catVisit);

		Vet emre = new Vet();
		emre.setFirstName("Emre");
		emre.setLastName("Doğan");
		// vet.setId(1L);
		emre.getSpec().add(radiologist);
		vetServiceB.save(emre);

		Vet emirMete = new Vet();
		emirMete.setFirstName("Emir Mete");
		emirMete.setLastName("Doğan");
		// vet2.setId(2L);
		emirMete.getSpec().add(surgery);
		emirMete.getSpec().add(dentistry);

		vetServiceB.save(emirMete);
	}

}
