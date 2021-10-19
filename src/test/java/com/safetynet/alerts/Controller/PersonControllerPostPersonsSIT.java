package com.safetynet.alerts.Controller;


import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.controllers.PersonController;
import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.model.Person;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PersonController.class, PersonsPostService.class})
@ExtendWith(SpringExtension.class)
public class PersonControllerPostPersonsSIT {

	@Inject
	private MockMvc mvc;

	@Autowired
	private PersonController personController;

	@BeforeAll
	public void prepare(){
		mvc = MockMvcBuilders.standaloneSetup(personController).build();
		Assertions.assertNotNull(mvc);
	}

	@Test
	void test_200_insert1Firestation() throws Exception{
		mvc.perform(post("/persons")
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(UTHelper.readFileAsString("requestBody/Firestations/firestations.json")))
				.andExpect(status().isOk());
	}
}
