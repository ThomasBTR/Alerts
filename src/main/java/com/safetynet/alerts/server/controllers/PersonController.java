package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.services.PersonGetService;
import com.safetynet.alerts.server.services.PersonPostService;
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
public class PersonController implements AddPersonsApi, ChildAlertApi, PhoneAlertApi, FireApi, FloodStationApi, PersonInfoApi, CommunityEmailApi, PersonApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	PersonPostService personPostService;

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
	public ResponseEntity<PersonRsp> addPerson(PersonReq body) {
		ResponseEntity<PersonRsp> response = null;

		try {
			response = ResponseEntity.ok(personPostService.addPerson(body));
			logger.info(String.format("%s %s added to the database", body.getFirstName(),body.getLastName()), response);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<Void> deletePerson(String firstName, String lastName) {
		ResponseEntity<Void> response = null;
		try {
			personPostService.deletePerson(firstName,lastName);
			response = (ResponseEntity<Void>) ResponseEntity.noContent();
			logger.info(String.format("%s %s deleted in the database", firstName, lastName), response);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<PersonRsp> updatePerson(String firstName, String lastName, PersonReq body) {
		ResponseEntity<PersonRsp> response = null;

		try {
			response = ResponseEntity.ok(personPostService.updatePerson(body));
			logger.info(String.format("%s %s updated in the database", firstName, lastName), response);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<PersonsRsp> addPersonsToDatabase(PersonsReq body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(personPostService.addPersons(body));
			logger.info("Multiple Persons added in database", response);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<CityMailingList> getMailingListFromCity(String city) {
		ResponseEntity<CityMailingList> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getCityMailingList(city));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}
}
