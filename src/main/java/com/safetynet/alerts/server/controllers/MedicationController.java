package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.api.AddMedicalRecordsApi;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MedicationController implements AddMedicalRecordsApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	PersonsPostService personsPostService;

	@Override
	public ResponseEntity<PersonsRsp> addPersonsToDatabase(PersonsReq body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(personsPostService.addPersons(body));
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}

		return response;
	}
}
