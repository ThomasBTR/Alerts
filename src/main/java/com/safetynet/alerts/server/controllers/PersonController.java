package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.constants.EActionsProceedConstants;
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
			logger.info(EActionsProceedConstants.CHILDALERT_SUCCESS.getValue(),address);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.PHONEALERT_ERROR.getValue(), e);
		}

		return response;
	}




	@Override
	public ResponseEntity<PersonInfo> getPersonInfos(String firstName, String lastName) {
		ResponseEntity<PersonInfo> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getPersonsInfos(firstName,lastName));
			logger.info(EActionsProceedConstants.PERSONINFO_SUCCESS.getValue(),firstName,lastName);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.PERSONINFO_ERROR.getValue(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<FloodStation> getAllPersonsInfosFromFirestationID(List firestation) {
		ResponseEntity<FloodStation> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getFloodStation(firestation));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<Fire> getPersonsInfosFromAddress(String address) {
		ResponseEntity<Fire> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getFireBody(address));
			logger.info(EActionsProceedConstants.FIREBODY_SUCCESS.getValue(),address);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.FIREBODY_ERROR.getValue(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<PhoneAlert> getPhoneNumbersFromFirestationID(Integer firestation) {
		ResponseEntity<PhoneAlert> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getPhoneAlert(firestation));
			logger.info(EActionsProceedConstants.PHONEALERT_SUCCESS.getValue(),firestation);

		} catch (Exception e) {
			logger.error(EActionsProceedConstants.PHONEALERT_ERROR.getValue(), e);
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
	public ResponseEntity<Void> addPerson(PersonReq body) {
		try {
			personPostService.addPerson(body);
			logger.info(EActionsProceedConstants.ADDING_PERSON_SUCCESS.getValue(), body.getFirstName(),body.getLastName());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.ADDING_PERSON_ERROR.getValue(), e);
		}

		return PersonApi.super.addPerson(body);
	}





	@Override
	public ResponseEntity<Void> deletePerson(String firstName, String lastName) {
		try {
			personPostService.deletePerson(firstName,lastName);
			logger.info(EActionsProceedConstants.DELETING_PERSON_SUCCESS.getValue(), firstName, lastName);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.DELETING_PERSON_ERROR.getValue(), e);
		}
		return PersonApi.super.deletePerson(firstName, lastName);
	}
	@Override
	public ResponseEntity<Void> updatePerson(String firstName, String lastName, PersonReq body) {
		try {
			personPostService.updatePerson(body);
			logger.info(EActionsProceedConstants.UPDATING_PERSON_SUCCESS.getValue(), firstName, lastName);
		} catch (Exception e) {
		logger.error(EActionsProceedConstants.UPDATING_PERSON_ERROR.getValue(), e);
		}

		return PersonApi.super.updatePerson(firstName, lastName, body);
	}

	@Override
	public ResponseEntity<PersonsRsp> addPersonsToDatabase(PersonsReq body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(personPostService.addPersons(body));
			logger.info(EActionsProceedConstants.ADDING_MULTIPLE_PERSONS_SUCCESS.getValue());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.ADDING_MULTIPLE_PERSONS_ERROR.getValue(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<CityMailingList> getMailingListFromCity(String city) {
		ResponseEntity<CityMailingList> response = null;

		try {
			response = ResponseEntity.ok(personGetService.getCityMailingList(city));
			logger.info(EActionsProceedConstants.COMMUNITYEMAIL_SUCCESS.getValue(),city);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.COMMUNITYEMAIL_ERROR.getValue(), e);
		}

		return response;
	}
}
