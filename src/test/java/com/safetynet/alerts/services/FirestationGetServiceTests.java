package com.safetynet.alerts.services;

import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.database.entities.*;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.services.FirestationGetServices;
import io.swagger.model.Firestation;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FirestationGetServiceTests {

	@Mock
	PersonRepository personRepository;

	FirestationGetServices firestationGetServices;

	PersonEntity adult = null;
	PersonEntity child = null;


	List<PersonEntity> personEntityListwithChild;
	List<PersonEntity> personEntityListwithoutChild;

	String address = "1509 Culver St";


	@BeforeAll
	void prepare() {

		personEntityListwithChild = new ArrayList<>();
		personEntityListwithoutChild = new ArrayList<>();

		firestationGetServices = new FirestationGetServices(personRepository);

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
	}


	@Test
	void StationNumber_Ok_ReturnFirestationBody(){
		// GIVEN
		int station = 3;

		when(firestationGetServices.personRepository.findPersonEntitiesByAddressEntityStation(station)).thenReturn(personEntityListwithChild);

		// WHEN
		Firestation firestation = firestationGetServices.getPersonsInfosFromFirestationID(station);

		// THEN
		verify(firestationGetServices.personRepository, times(1)).findPersonEntitiesByAddressEntityStation(station);
		assertThat(firestation).isInstanceOf(Firestation.class);
		try {
			assertThat(firestation).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/floodstation_200.json"), Firestation.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void StationNumberAdd_Ok_ReturnStationNumberBody(){
		// GIVEN
		int station = 3;

		when(firestationGetServices.personRepository.findPersonEntityByAddressEntityEquals(address)).thenReturn(personEntityListwithChild);

		// WHEN
		firestationGetServices.addFirestationMappingToASpecifiedAddress(station, address);

		// THEN
		verify(firestationGetServices.personRepository, times(1)).findPersonEntityByAddressEntityEquals(address);
	}

	@Test
	void StationNumberUpdate_Ok_ReturnStationNumberBody(){
		// GIVEN
		int station = 3;

		when(firestationGetServices.personRepository.findPersonEntityByAddressEntityEquals(address)).thenReturn(personEntityListwithChild);

		// WHEN
		firestationGetServices.updateFirestationMappingToASpecifiedAddress(station, address);

		// THEN
		verify(firestationGetServices.personRepository, times(1)).findPersonEntityByAddressEntityEquals(address);

	}
}
