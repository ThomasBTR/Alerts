package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.services.MedicationPostServices;
import io.swagger.api.AddMedicalRecordsApi;
import io.swagger.model.Medicalrecords;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(MedicationController.class);

	@Override
	public ResponseEntity<PersonsRsp> addMedicalRecordsToDatabase(Medicalrecords body) {
		ResponseEntity<PersonsRsp> response = null;

		try {
			response = ResponseEntity.ok(medicationsPostServices.addMedications(body));
			logger.info(EActionsProceedConstants.ADDING_MULTIPLE_MEDICATIONS_SUCCESS.getValue());
		} catch (Exception e) {
			logger.error(EActionsProceedConstants.ADDING_MULTIPLE_MEDICATIONS_ERROR.getValue(), e);
		}

		return response;
	}
}
