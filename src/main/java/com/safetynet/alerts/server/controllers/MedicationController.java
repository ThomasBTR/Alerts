package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.services.MedicationServices;
import io.swagger.api.AddMedicalRecordsApi;
import io.swagger.api.MedicalRecordApi;
import io.swagger.model.MedicalRecord;
import io.swagger.model.Medicalrecords;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class MedicationController implements AddMedicalRecordsApi, MedicalRecordApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	MedicationServices medicationServices;


	private static final Logger logger = LoggerFactory.getLogger(MedicationController.class);

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return AddMedicalRecordsApi.super.getObjectMapper();
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return AddMedicalRecordsApi.super.getRequest();
	}

	@Override
	public Optional<String> getAcceptHeader() {
		return AddMedicalRecordsApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<Void> addMedicalRecord(MedicalRecord body) {
		try {
			medicationServices.addMedication(body);
			logger.info(EActionsProceedConstants.ADDING_MEDICALRECORD_SUCCESS.getValue(), body.getFirstName(), body.getLastName());
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return MedicalRecordApi.super.addMedicalRecord(body);
	}

	@Override
	public ResponseEntity<Void> deleteMedicalRecord(String firstName, String lastName) {
		return MedicalRecordApi.super.deleteMedicalRecord(firstName, lastName);
	}

	@Override
	public ResponseEntity<Void> updateMedicalRecord(String firstName, String lastName, MedicalRecord body) {
		return MedicalRecordApi.super.updateMedicalRecord(firstName, lastName, body);
	}

	@Override
	public ResponseEntity<PersonsRsp> addMedicalRecordsToDatabase(Medicalrecords body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(medicationServices.addMedications(body));

		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}

		return response;
	}


}
