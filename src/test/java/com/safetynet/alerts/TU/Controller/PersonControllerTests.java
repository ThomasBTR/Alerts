package com.safetynet.alerts.TU.Controller;

import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.controllers.PersonController;
import com.safetynet.alerts.server.database.entities.*;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.services.PersonGetService;
import com.safetynet.alerts.server.services.PersonPostService;
import io.swagger.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
class PersonControllerTests {

	PersonController personController;

	@Mock
	PersonRepository personRepository;

	@Mock
	PersonPostService personPostService;

	@Mock
	PersonGetService personGetService;

	String address = "1509 Culver St";
	int station = 3;

	ChildAlert childAlert = null;
	PhoneAlert phoneAlert = null;
	FloodStation floodStation = null;

	PersonEntity adult = null;
	PersonEntity child = null;


	List<PersonEntity> personEntityListwithChild;
	List<PersonEntity> personEntityListwithoutChild;

	PersonReq personReq = null;

	@BeforeEach
	void prepare() {
		personController = new PersonController(personGetService, personPostService);

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

	@Tag("Get endpoints")
	@Test
	void childAlert_OK_returnChildAlert() {
		// GIVEN
		try {
			childAlert = UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertWithChild.json"), ChildAlert.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		when(personGetService.getChildrenInfoFromAddress(address)).thenReturn(childAlert);

		// WHEN
		ResponseEntity<ChildAlert> response = personController.getChildrenInfoFromAddress(address);

		// THEN
		verify(personGetService, times(1)).getChildrenInfoFromAddress(address);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(ChildAlert.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertWithChild.json"), ChildAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void childAlert_OK_returnChildAlertWithoutChild() {
		// GIVEN
		try {
			childAlert = UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertEmpty.json"), ChildAlert.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		when(personGetService.getChildrenInfoFromAddress(address)).thenReturn(childAlert);

		// WHEN
		ResponseEntity<ChildAlert> response = personController.getChildrenInfoFromAddress(address);

		// THEN
		verify(personGetService, times(1)).getChildrenInfoFromAddress(address);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(ChildAlert.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertEmpty.json"), ChildAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void PhoneAlert_OK_ReturnPhoneList() {
		// GIVEN
		String filepath = "responseBody/Persons/phoneAlert_200.json";
		try {
			phoneAlert = UTHelper.stringToObject(UTHelper.readFileAsString(filepath), PhoneAlert.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		when(personGetService.getPhoneAlert(station)).thenReturn(phoneAlert);

		// WHEN
		ResponseEntity<PhoneAlert> response = personController.getPhoneNumbersFromFirestationID(station);

		// THEN
		verify(personGetService, times(1)).getPhoneAlert(station);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(PhoneAlert.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), PhoneAlert.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void Fire_OK_ReturnFireObject() {
		// GIVEN
		String filepath = "responseBody/Persons/fire_200.json";
		Fire fire = new Fire();
		try {
			fire = UTHelper.stringToObject(UTHelper.readFileAsString(filepath), Fire.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		when(personGetService.getFireBody(address)).thenReturn(fire);

		// WHEN
		ResponseEntity<Fire> response = personController.getPersonsInfosFromAddress(address);

		// THEN
		verify(personGetService, times(1)).getFireBody(address);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(Fire.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), Fire.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void FloodStation_OK_ReturnFloodStation_Body() {
		// GIVEN
		String filepath = "responseBody/Persons/floodstation_200.json";
		try {
			floodStation = UTHelper.stringToObject(UTHelper.readFileAsString(filepath), FloodStation.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> stationList = new ArrayList<>();
		stationList.add(station);

		when(personGetService.getFloodStation(stationList)).thenReturn(floodStation);

		// WHEN
		ResponseEntity<FloodStation> response = personController.getAllPersonsInfosFromFirestationID(stationList);

		// THEN
		verify(personGetService, times(1)).getFloodStation(stationList);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(FloodStation.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), FloodStation.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void PersonInfo_OK_ReturnPersonInfo_Body() {
		// GIVEN
		String filepath = "responseBody/Persons/personInfo_200.json";
		String firstName = "John";
		String lastName = "Boyd";
		PersonInfo personInfo = new PersonInfo();
		try {
			personInfo = UTHelper.stringToObject(UTHelper.readFileAsString(filepath), PersonInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		when(personGetService.getPersonsInfos(firstName, lastName)).thenReturn(personInfo);

		// WHEN
		ResponseEntity<PersonInfo> response = personController.getPersonInfos(firstName, lastName);

		// THEN
		verify(personGetService, times(1)).getPersonsInfos(firstName, lastName);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(PersonInfo.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), PersonInfo.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("Get endpoints")
	@Test
	void Email_OK_ReturnEmails_Body() {
		// GIVEN
		String filepath = "responseBody/Persons/cityMailingList_200.json";
		String city = "Culver";
		CityMailingList cityMailingList = new CityMailingList();
		try {
			cityMailingList = UTHelper.stringToObject(UTHelper.readFileAsString(filepath), CityMailingList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		when(personGetService.getCityMailingList(city)).thenReturn(cityMailingList);

		// WHEN
		ResponseEntity<CityMailingList> response = personController.getMailingListFromCity(city);

		// THEN
		verify(personGetService, times(1)).getCityMailingList(city);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(CityMailingList.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), CityMailingList.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Tag("POST endpoints")
	@Test
	void personpost_200_ReturnBody() {

		// GIVEN

		// WHEN
		ResponseEntity<Void> response = personController.addPerson(personReq);

		// THEN
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Tag("PUT endpoints")
	@Test
	void personput_200_ReturnBody() {

		// GIVEN

		// WHEN
		ResponseEntity<Void> response = personController.updatePerson(personReq.getFirstName(), personReq.getLastName(), personReq);

		// THEN
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Tag("DELETE endpoints")
	@Test
	void persondelete_200_ReturnBody() {
		// GIVEN
		// WHEN
		ResponseEntity<Void> response = personController.deletePerson(personReq.getFirstName(), personReq.getLastName());

		// THEN
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

}
