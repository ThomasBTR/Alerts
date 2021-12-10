package com.safetynet.alerts.TU.Controller;

import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.controllers.PersonController;
import com.safetynet.alerts.server.services.PersonGetService;
import com.safetynet.alerts.server.services.PersonPostService;
import io.swagger.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
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
	PersonPostService personPostService;

	@Mock
	PersonGetService personGetService;

	String address = "1509 Culver St";
	int station = 3;

	ChildAlert childAlert = null;
	PhoneAlert phoneAlert = null;
	FloodStation floodStation = null;


	@BeforeEach
	void prepare() {
		personController = new PersonController(personGetService,personPostService);
	}

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

		when(personGetService.getPersonsInfos(firstName,lastName)).thenReturn(personInfo);

		// WHEN
		ResponseEntity<PersonInfo> response = personController.getPersonInfos(firstName,lastName);

		// THEN
		verify(personGetService, times(1)).getPersonsInfos(firstName,lastName);
		assertThat(response).isInstanceOf(ResponseEntity.class);
		assertThat(response.getBody()).isInstanceOf(PersonInfo.class);
		try {
			assertThat(response.getBody()).isEqualTo(UTHelper.stringToObject(UTHelper.readFileAsString(filepath), PersonInfo.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
