package com.safetynet.alerts.Controller;


import com.google.inject.Inject;
import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.controllers.PersonController;
import com.safetynet.alerts.server.services.PersonsPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PersonController.class, PersonsPostService.class})
@ExtendWith(SpringExtension.class)
class PersonControllerPostPersonsSIT {

	@Inject
	private MockMvc mvc;

	@Autowired
	private PersonController personController;

	@BeforeAll
	public void prepare() {
		mvc = MockMvcBuilders.standaloneSetup(personController).build();
		Assertions.assertNotNull(mvc);
	}

	@Test
	@DisplayName("Should response 200 with person added to the database as json response")
	void test_200_insert1Firestation() throws Exception {
		mvc.perform(post("/persons")
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(UTHelper.readFileAsString("requestBody/Persons/persons_1value.json")))
				.andExpect(status().isOk())
				.andExpect(content().json(UTHelper.readFileAsString("responseBody/Persons/200OK_persons.json")));

		assertThat(true).isTrue();
	}
}
