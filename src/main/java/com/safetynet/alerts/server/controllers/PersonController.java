package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.services.PersonGetService;
import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.api.AddPersonsApi;
import io.swagger.api.ChildAlertApi;
import io.swagger.model.ChildAlert;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class PersonController implements AddPersonsApi, ChildAlertApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	PersonsPostService personsPostService;

	PersonGetService personGetService;

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return AddPersonsApi.super.getObjectMapper();
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return AddPersonsApi.super.getRequest();
	}

	@Override
	public Optional<String> getAcceptHeader() {
		return AddPersonsApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<PersonsRsp> addPersonsToDatabase(PersonsReq body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(personsPostService.addPersons(body));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<ChildAlert> getChildrenInfoFromAddress(String address) {
		ResponseEntity<ChildAlert> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getChildrenInfoFromAddress(address));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return response;
	}
}
