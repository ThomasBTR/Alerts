package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.services.FirestationGetServices;
import io.swagger.api.AddFirestationsApi;
import io.swagger.api.StationNumberApi;
import io.swagger.model.Firestation;
import io.swagger.model.Firestations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/firestation")
public class FirestationController implements StationNumberApi, AddFirestationsApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	FirestationGetServices firestationGetServices;

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return StationNumberApi.super.getObjectMapper();
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return StationNumberApi.super.getRequest();
	}

	@Override
	public Optional<String> getAcceptHeader() {
		return StationNumberApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<Void> addFirestationMappingToSpecifiedAddress(String address) {
		return StationNumberApi.super.addFirestationMappingToSpecifiedAddress(address);
	}

	@Override
	public ResponseEntity<Void> deleteFirestationMappingToSpecifiedAddress(String address) {
		return StationNumberApi.super.deleteFirestationMappingToSpecifiedAddress(address);
	}

	@Override
	public ResponseEntity<Firestation> getPersonsInfosFromFirestationID(String stationNumber) {

		if (null == stationNumber) {
			return ResponseEntity.noContent().build();
		} else {
			try {
				return firestationGetServices.processFirestationID(stationNumber);
			} catch (Exception e) {
//				log.warn(e.getMessage());
				return ResponseEntity.internalServerError().build();
			}

		}
	}

	@Override
	public ResponseEntity<Void> updateFirestationMappingToSpecifiedAddress(String address) {
		return StationNumberApi.super.updateFirestationMappingToSpecifiedAddress(address);
	}


	@Override
	public ResponseEntity<Void> addFirestationToDatabase(Firestations body) {
		return AddFirestationsApi.super.addFirestationToDatabase(body);
	}
}
