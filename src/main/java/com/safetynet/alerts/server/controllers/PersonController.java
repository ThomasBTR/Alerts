package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.services.PersonGetService;
import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.api.*;
import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController implements AddPersonsApi, ChildAlertApi, PhoneAlertApi, FireApi, FloodStationApi, PersonInfoApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	PersonsPostService personsPostService;

	PersonGetService personGetService;

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

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
	public ResponseEntity<PersonInfo> getPersonInfos(String firstName, String lastName) {
		ResponseEntity<PersonInfo> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getPersonsInfos(firstName,lastName));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<FloodStation> getAllPersonsInfosFromFirestationID(List firestation) {
		ResponseEntity<FloodStation> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getFloodStation(firestation));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<Fire> getPersonsInfosFromAddress(String address) {
		ResponseEntity<Fire> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getFireBody(address));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<PhoneAlert> getPhoneNumbersFromFirestationID(Integer firestation) {
		ResponseEntity<PhoneAlert> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getPhoneAlert(firestation));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
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
}
