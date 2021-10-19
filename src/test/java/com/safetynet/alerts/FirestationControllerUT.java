package com.safetynet.alerts;

import com.safetynet.alerts.server.controllers.FirestationController;
import io.swagger.model.Firestation;
import io.swagger.model.Firestations;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestClientException;

import javax.persistence.PersistenceException;


@SpringBootTest
@TestInstance(value= TestInstance.Lifecycle.PER_CLASS)
public class FirestationControllerUT {

	private MockMvc mvc;

	@Autowired
	private FirestationController firestationControllerUnderTest;

	@BeforeAll
	public void prepare(){
		mvc = MockMvcBuilders.standaloneSetup(firestationControllerUnderTest)
				.build();
	}


	@Test
	void insertFirestationsIntoDatabase_shouldReturn200OK(){
		//GIVEN

		//WHEN
		firestationControllerUnderTest.addFirestationToDatabase(new Firestations());


	}


	@Test
	void processFirestationID_ReturnAFirestationResponse(){
		//GIVEN
		String stationNumber = "1";

		//WHEN
		ResponseEntity<Firestation> test = firestationControllerUnderTest.getPersonsInfosFromFirestationID(stationNumber);
		//THEN
		//TODO create assertion and Object in JSON to check if it is coherent
		//assertThat(test).isEqualTo();
	}

}
