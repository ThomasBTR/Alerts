package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IFirestationMapper;
import io.swagger.model.Firestation;
import io.swagger.model.PersonReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FirestationGetServices {

	@Autowired
	PersonRepository personRepository;

	public ResponseEntity<Firestation> processFirestationID(String stationNumber) {

		List<PersonEntity> personEntities = personRepository.findPersonEntitiesByAddressEntityStation(Integer.parseInt(stationNumber));
		int adultCount = 0;
		int childCount = 0;

		for (final PersonEntity personEntity : personEntities) {
			if (personEntity.getBirthdate().isAfter(LocalDate.now().minusYears(18))) {
				++childCount;
			} else {
				++adultCount;
			}
		}

		List<PersonReq> persons = IFirestationMapper.INSTANCE.personEntityListToFirestationPerson(personEntities);

		Firestation firestationResponseBody = new Firestation();

		firestationResponseBody.setAdultCount(adultCount);
		firestationResponseBody.setChildCount(childCount);
		firestationResponseBody.setPersons(persons);

		return ResponseEntity.ok(firestationResponseBody);
	}
}
