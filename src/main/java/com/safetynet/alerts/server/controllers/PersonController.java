package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.api.AddPersonsApi;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonController implements AddPersonsApi {

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
