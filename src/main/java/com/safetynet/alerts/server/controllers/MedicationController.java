package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.services.MedicationPostServices;
import io.swagger.api.AddMedicalRecordsApi;
import io.swagger.model.Medicalrecords;
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
	MedicationPostServices medicationsPostServices;

	@Override
	public ResponseEntity<PersonsRsp> addMedicalRecordsToDatabase(Medicalrecords body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(medicationsPostServices.addMedications(body));
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}

		return response;
	}
}
