package com.safetynet.alerts.services;

import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.database.entities.*;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.services.PersonPostService;
import io.swagger.model.PersonReq;
import io.swagger.model.PersonRsp;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonPostServiceTests {

	@Mock
	PersonRepository personRepository;

	PersonPostService personPostService;

	PersonEntity adult = null;
	PersonEntity child = null;


	List<PersonEntity> personEntityListwithChild;
	List<PersonEntity> personEntityListwithoutChild;

	PersonReq personReq = null;

	String address = "1509 Culver St";


	@BeforeAll
	void prepare() {

		personEntityListwithChild = new ArrayList<>();
		personEntityListwithoutChild = new ArrayList<>();

		personPostService = new PersonPostService(personRepository);

		MedicationEntity medicationEntity = new MedicationEntity();

		AddressEntity addressEntity = new AddressEntity();

		List<MedicationEntity> medicationEntities = new ArrayList<>();

		MedicineEntity medicineEntity = new MedicineEntity();

		List<AllergeneEntity> allergeneEntities = new ArrayList<>();

		AllergeneEntity allergeneEntity = new AllergeneEntity();

		String phone = "841-874-6512";


		addressEntity.setAddress(address);
		addressEntity.setStation(1);
		addressEntity.setCity("Culver");
		addressEntity.setZip("97451");

		medicineEntity.setMedecineName("aznol");
		medicineEntity.setId(0);

		medicationEntity.setDosage(350);
		medicationEntity.setMedicineEntity(medicineEntity);
		medicationEntity.setId(0);

		allergeneEntity.setAllergene("nillacilan");
		allergeneEntity.setId(0);
		allergeneEntities.add(allergeneEntity);

		NameEntity adultName = new NameEntity();
		adultName.setFirstName("John");
		adultName.setLastName("Boyd");

		NameEntity childName = new NameEntity();
		childName.setFirstName("Tenley");
		childName.setLastName("Boyd");

		adult = new PersonEntity();
		adult.setBirthdate(LocalDate.of(1984, 3, 6));
		adult.setAddressEntity(addressEntity);
		adult.setPhone(phone);
		adult.setAllergies(allergeneEntities);
		adult.setMedications(medicationEntities);
		adult.setNameEntity(adultName);
		adult.setEmail("jaboyd@email.com");

		child = new PersonEntity();
		child.setMedications(medicationEntities);
		child.setAddressEntity(addressEntity);
		child.setPhone(phone);
		child.setAllergies(allergeneEntities);
		child.setMedications(medicationEntities);
		child.setBirthdate(LocalDate.of(2012, 2, 18));
		child.setNameEntity(childName);
		child.setEmail("tenz@email.com");

		personEntityListwithChild.add(child);
		personEntityListwithChild.add(adult);
		personEntityListwithoutChild.add(adult);

		personReq = new PersonReq();
		personReq.setEmail(adult.getEmail());
		personReq.setPhone(adult.getPhone());
		personReq.setAddress(adult.getAddressEntity().getAddress());
		personReq.setCity(adult.getAddressEntity().getCity());
		personReq.setZip(adult.getAddressEntity().getZip());
		personReq.setFirstName(adult.getNameEntity().getFirstName());
		personReq.setLastName(adult.getNameEntity().getLastName());

	}


	@Test
	void personPost_200_ReturnOKBody(){

		// GIVEN
		when(personPostService.personRepository.save(any(PersonEntity.class))).thenReturn(adult);

		// WHEN
		PersonRsp personRsp = personPostService.addPerson(personReq);

		// THEN
		verify(personPostService.personRepository, times(1)).save(any(PersonEntity.class));
		AssertionsForClassTypes.assertThat(personRsp).isInstanceOf(PersonRsp.class);
		try {
			AssertionsForClassTypes.assertThat(personRsp).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/person_200.json"), PersonRsp.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	void personDelete_200_ReturnVoid(){
		// GIVEN
		String firstName = adult.getNameEntity().getFirstName();
		String lastName = adult.getNameEntity().getLastName();
		// WHEN
		personPostService.deletePerson(firstName, lastName);

		// THEN
		verify(personPostService.personRepository, times(1)).delete(personRepository.findPersonEntityByNameEntityLike(firstName,lastName));
	}

}