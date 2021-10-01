package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.database.entities.PersonEntity;
import com.safetynet.alerts.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.FirestationMapper;
import io.swagger.api.StationNumberApi;
import io.swagger.model.Firestation;
import io.swagger.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/firestation")
public class FirestationController implements StationNumberApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private PersonRepository personRepository;

	private static final FirestationMapper FIRESTATION_MAPPER = FirestationMapper.INSTANCE;

	@Override
	public ResponseEntity<Firestation> getPersonsInfosFromFirestationID(String stationNumber) {

		if (null == stationNumber) {
			return ResponseEntity.noContent().build();
		} else {
			try {
				return processFirestationID(stationNumber);
			} catch (Exception e) {
				log.warn(e.getMessage());
				return ResponseEntity.internalServerError().build();
			}

		}
	}

	private ResponseEntity<Firestation> processFirestationID(String stationNumber) {

		List<PersonEntity> personEntities = personRepository.findPersonEntitiesByAddressEntityStation(Integer.parseInt(stationNumber));
		int adultCount = 0;
		int childCount = 0;

		for (PersonEntity personEntity : personEntities) {
			if (personEntity.getBirthdate().isAfter(LocalDate.now().minusYears(18))) {
				++childCount;
			} else {
				++adultCount;
			}
		}

		List<Person> persons = FIRESTATION_MAPPER.personEntityListToFirestationPerson(personEntities);

		Firestation firestationResponseBody = new Firestation();

		firestationResponseBody.setAdultCount(adultCount);
		firestationResponseBody.setChildCount(childCount);
		firestationResponseBody.setPersons(persons);

		return ResponseEntity.ok(firestationResponseBody);
	}
}
