package com.safetynet.alerts.Controller;


import com.google.inject.Inject;
import com.safetynet.alerts.UTHelper;
import com.safetynet.alerts.server.controllers.PersonController;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.services.PersonGetService;
import io.swagger.model.ChildAlert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PersonController.class, PersonGetService.class})
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonControllerGetPersonsSIT {

	@Inject
	private MockMvc mvc;

	@MockBean
	PersonRepository personRepository;

	@MockBean
	PersonGetService personGetService;

	@MockBean
	private PersonController personController;



	@BeforeAll
	public void prepare() {
		mvc = MockMvcBuilders.standaloneSetup(personController).build();
		Assertions.assertNotNull(mvc);
	}

	@Disabled
	@Test
	@DisplayName("Should response 200 with when an address is given and return a ChildAlert JSON response")
	void getChildAlert_200_station3() throws Exception {
		// GIVEN
		String address = "1509 Culver St";

		when(personGetService.getChildrenInfoFromAddress(address)).thenReturn(UTHelper.stringToObject(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertWithChild.json"), ChildAlert.class));

		// WHEN
		mvc.perform(get("/childAlert")
						.header("address",address))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json(UTHelper.readFileAsString("responseBody/ChildAlert/childAlertWithChild.json")));

		assertThat(true).isTrue();
	}
}
