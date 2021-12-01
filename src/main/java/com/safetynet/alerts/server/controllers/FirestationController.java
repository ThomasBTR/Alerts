package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.services.FirestationGetServices;
import com.safetynet.alerts.server.services.FirestationPostServices;
import io.swagger.api.AddFirestationsApi;
import io.swagger.api.StationNumberApi;
import io.swagger.model.AddressesRsp;
import io.swagger.model.Firestation;
import io.swagger.model.Firestations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class FirestationController implements AddFirestationsApi, StationNumberApi{

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	FirestationGetServices firestationGetServices;

	@Autowired
	FirestationPostServices firestationPostServices;

	private static final Logger logger = LoggerFactory.getLogger(FirestationController.class);


	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return AddFirestationsApi.super.getObjectMapper();
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return AddFirestationsApi.super.getRequest();
	}

	@Override
	public Optional<String> getAcceptHeader() {
		return AddFirestationsApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<AddressesRsp> addFirestationToDatabase(Firestations body) {
		ResponseEntity<AddressesRsp> response = null;

		try {
			response = ResponseEntity.ok(firestationPostServices.addFirestations(body));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<Firestation> getPersonsInfosFromFirestationID(Integer stationNumber) {
		ResponseEntity<Firestation> response = null;

		try {
			response = ResponseEntity.ok(firestationGetServices.getPersonsInfosFromFirestationID(stationNumber));
			logger.info(EActionsProceedConstants.FIRESTATIONINFOS_FROMID_SUCCESS.getValue(), stationNumber);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}

	@Override
	public ResponseEntity<Void> addFirestationMappingToSpecifiedAddress(String address, Integer stationNumber) {
		try {
			firestationGetServices.addFirestationMappingToASpecifiedAddress(stationNumber, address);
			logger.info(EActionsProceedConstants.ADDING_FIRESTATION_SUCCESS.getValue(), stationNumber, address);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return StationNumberApi.super.addFirestationMappingToSpecifiedAddress(address, stationNumber);
	}

	@Override
	public ResponseEntity<Void> updateFirestationMappingToSpecifiedAddress(String address, Integer stationNumber) {
		try {
			firestationGetServices.updateFirestationMappingToASpecifiedAddress(stationNumber, address);
			logger.info(EActionsProceedConstants.UPDATING_FIRESTATION_SUCCESS.getValue(), stationNumber, address);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return StationNumberApi.super.updateFirestationMappingToSpecifiedAddress(address, stationNumber);
	}

	@Override
	public ResponseEntity<Void> deleteFirestationMappingToSpecifiedAddress(String address, Integer stationNumber) {
		try {
			firestationGetServices.deleteFirestationMappingToASpecifiedAddress(stationNumber, address);
			logger.info(EActionsProceedConstants.DELETING_FIRESTATION_SUCCESS.getValue(), stationNumber, address);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return StationNumberApi.super.deleteFirestationMappingToSpecifiedAddress(address, stationNumber);
	}
}
