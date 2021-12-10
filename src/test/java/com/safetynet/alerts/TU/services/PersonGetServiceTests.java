package com.safetynet.alerts.TU.services;

import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.database.entities.*;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.services.PersonGetService;
import io.swagger.model.*;
import org.junit.jupiter.api.BeforeEach;
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
class PersonGetServiceTests {

	@Mock
	PersonRepository personRepository;

	PersonGetService personGetService;

	PersonEntity adult = null;
	PersonEntity child = null;


	List<PersonEntity> personEntityListwithChild;
	List<PersonEntity> personEntityListwithoutChild;

	String address = "1509 Culver St";


	@BeforeEach
	void prepare() {

		personEntityListwithChild = new ArrayList<>();
		personEntityListwithoutChild = new ArrayList<>();

		personGetService = new PersonGetService(personRepository);

		MedicationEntity medicationEntity1 = new MedicationEntity();
		MedicationEntity medicationEntity2 = new MedicationEntity();

		AddressEntity addressEntity = new AddressEntity();

		List<MedicationEntity> medicationEntities = new ArrayList<>();

		MedicineEntity medicineEntity1 = new MedicineEntity();
		MedicineEntity medicineEntity2 = new MedicineEntity();

		List<AllergeneEntity> allergeneEntities = new ArrayList<>();

		AllergeneEntity allergeneEntity = new AllergeneEntity();

		String phone = "841-874-6512";


		addressEntity.setAddress(address);
		addressEntity.setStation(1);
		addressEntity.setCity("Culver");
		addressEntity.setZip("97451");

		medicineEntity1.setMedecineName("aznol");
		medicineEntity1.setId(1);

		medicationEntity1.setDosage(350);
		medicationEntity1.setMedicineEntity(medicineEntity1);
		medicationEntity1.setId(1);
		medicationEntities.add(medicationEntity1);

		medicineEntity2.setMedecineName("hydrapermazol");
		medicineEntity2.setId(2);

		medicationEntity2.setDosage(100);
		medicationEntity2.setMedicineEntity(medicineEntity2);
		medicationEntity2.setId(2);
		medicationEntities.add(medicationEntity2);

		allergeneEntity.setAllergene("nillacilan");
		allergeneEntity.setId(1);
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
	void childAlert_OK_returnChildAlert() {
		// GIVEN
		when(personGetService.personRepository.findPersonEntityByAddressEntityEquals(address)).thenReturn(personEntityListwithChild);

		// WHEN
		ChildAlert childAlert = personGetService.getChildrenInfoFromAddress(address);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntityByAddressEntityEquals(address);
		assertThat(childAlert).isInstanceOf(ChildAlert.class);
		try {
			assertThat(childAlert).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertWithChild.json"), ChildAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void childAlert_OK_returnChildAlertWithoutChild() {
		// GIVEN
		when(personGetService.personRepository.findPersonEntityByAddressEntityEquals(address)).thenReturn(personEntityListwithoutChild);

		// WHEN
		ChildAlert childAlert = personGetService.getChildrenInfoFromAddress(address);

		// THEN
		verify(personGetService.personRepository, times(3)).findPersonEntityByAddressEntityEquals(address);
		assertThat(childAlert).isInstanceOf(ChildAlert.class);
		try {
			assertThat(childAlert).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertEmpty.json"), ChildAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void PhoneAlert_Ok_ReturnPhoneList(){
		// GIVEN
		int station = 3;
		when(personGetService.personRepository.findPersonEntitiesByAddressEntityContainingSpecificStation(station)).thenReturn(personEntityListwithChild);

		// WHEN
		PhoneAlert phoneAlert = personGetService.getPhoneAlert(station);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntitiesByAddressEntityContainingSpecificStation(station);
		assertThat(phoneAlert).isInstanceOf(PhoneAlert.class);
		try {
			assertThat(phoneAlert).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/phoneAlert_200.json"), PhoneAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void Fire_Ok_ReturnFire_Get_Json(){
		// GIVEN
		when(personGetService.personRepository.findPersonEntityByAddressEntityEquals(address)).thenReturn(personEntityListwithChild);

		// WHEN
		Fire fireBody = personGetService.getFireBody(address);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntityByAddressEntityEquals(address);
		assertThat(fireBody).isInstanceOf(Fire.class);
		try {
			assertThat(fireBody).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/fire_200.json"), Fire.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void FloodStation_Ok_ReturnFloodStation_Body(){
		// GIVEN
		int station = 3;
		List<Integer> firestationList = new ArrayList<>();
		firestationList.add(station);
		when(personGetService.personRepository.findPersonEntitiesByAddressEntityContainingSpecificStation(station)).thenReturn(personEntityListwithChild);

		// WHEN
		FloodStation floodStation = personGetService.getFloodStation(firestationList);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntitiesByAddressEntityContainingSpecificStation(station);
		assertThat(floodStation).isInstanceOf(FloodStation.class);
		try {
			assertThat(floodStation).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/floodstation_200.json"), FloodStation.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void PersonInfo_Ok_ReturnPersonInfo_Body(){
		// GIVEN
		String firstName = adult.getNameEntity().getFirstName();
		String lastName = adult.getNameEntity().getLastName();

		when(personGetService.personRepository.findPersonEntityByNameEntityLike(firstName,lastName)).thenReturn(adult);

		// WHEN
		PersonInfo personsInfos = personGetService.getPersonsInfos(firstName,lastName);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntityByNameEntityLike(firstName, lastName);
		assertThat(personsInfos).isInstanceOf(PersonInfo.class);
		try {
			assertThat(personsInfos).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/personInfo_200.json"), PersonInfo.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void Email_Ok_ReturnEmails_Body(){
		// GIVEN
		String city = adult.getAddressEntity().getCity();

		when(personGetService.personRepository.findPersonEntitiesByAddressEntityContainingCity(city)).thenReturn(personEntityListwithChild);

		// WHEN
		CityMailingList cityMailingList = personGetService.getCityMailingList(city);

		// THEN
		verify(personGetService.personRepository, times(1)).findPersonEntitiesByAddressEntityContainingCity(city);
		assertThat(cityMailingList).isInstanceOf(CityMailingList.class);
		try {
			assertThat(cityMailingList).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/Persons/cityMailingList_200.json"), CityMailingList.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
