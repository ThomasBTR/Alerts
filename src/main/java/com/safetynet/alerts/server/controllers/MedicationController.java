package com.safetynet.alerts.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.services.MedicationPostServices;
import io.swagger.api.AddMedicalRecordsApi;
import io.swagger.api.MedicalRecordApi;
import io.swagger.model.MedicalRecord;
import io.swagger.model.Medicalrecords;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class MedicationController implements AddMedicalRecordsApi, MedicalRecordApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	MedicationPostServices medicationsPostServices;

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
			medicationsPostServices.addMedicalRecord(body);
			logger.info(EActionsProceedConstants.ADDING_MEDICAL_RECORD_SUCCESS.getValue(), body.getFirstName(), body.getLastName());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.ADDING_MEDICAL_RECORD_ERROR.getValue(), e);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteMedicalRecord(String firstName, String lastName) {
		try {
			medicationsPostServices.deleteMedicalRecord(firstName, lastName);
			logger.info(EActionsProceedConstants.DELETING_MEDICAL_RECORD_SUCCESS.getValue(), firstName, lastName);
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.DELETING_MEDICAL_RECORD_ERROR.getValue(), e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Void> updateMedicalRecord(String firstName, String lastName, MedicalRecord body) {
		try {
			medicationsPostServices.updateMedicalRecord(firstName, lastName, body);
			logger.info(EActionsProceedConstants.UPDATING_MEDICAL_RECORD_SUCCESS.getValue(), body.getFirstName(), body.getLastName());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.UPDATING_MEDICAL_RECORD_ERROR.getValue(), e);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<PersonsRsp> addMedicalRecordsToDatabase(Medicalrecords body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(medicationsPostServices.addMedicalRecords(body));
			logger.info(EActionsProceedConstants.ADDING_MULTIPLE_MEDICAL_RECORDS_SUCCESS.getValue());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.ADDING_MULTIPLE_MEDICAL_RECORDS_ERROR.getValue(), e);
		}

		return response;
	}
}
