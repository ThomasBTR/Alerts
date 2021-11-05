package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.services.FirestationGetServices;
import com.safetynet.alerts.server.services.FirestationPostServices;
import io.swagger.api.AddFirestationsApi;
import io.swagger.model.AddressesRsp;
import io.swagger.model.Firestations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FirestationController implements AddFirestationsApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	FirestationGetServices firestationGetServices;

	@Autowired
	FirestationPostServices firestationPostServices;

	@Override
	public ResponseEntity<AddressesRsp> addFirestationToDatabase(Firestations body) {
		ResponseEntity<AddressesRsp> response = null;

		try {
			response = ResponseEntity.ok(firestationPostServices.addFirestations(body));
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}

		return response;

	}


	//
//	@Override
//	public ResponseEntity<Firestation> getPersonsInfosFromFirestationID(String stationNumber) {
//
//		if (null == stationNumber) {
//			return ResponseEntity.noContent().build();
//		} else {
//			try {
//				return firestationGetServices.processFirestationID(stationNumber);
//			} catch (Exception e) {
////				log.warn(e.getMessage());
//				return ResponseEntity.internalServerError().build();
//			}
//
//		}
//	}
}
