package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.constants.EObjectConstants;
import com.safetynet.alerts.server.constants.EStatusConstants;
import com.safetynet.alerts.server.database.entities.AddressEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IFirestationMapper;
import io.swagger.model.Firestation;
import io.swagger.model.PersonReq;
import io.swagger.model.StationNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FirestationGetServices {

	@Autowired
	public PersonRepository personRepository;


//	private static final Logger logger = LoggerFactory.getLogger(FirestationGetServices.class);

	FirestationGetServices(){}

	public FirestationGetServices(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	public Firestation getPersonsInfosFromFirestationID(Integer stationNumber) {

		List<PersonEntity> personEntities = personRepository.findPersonEntitiesByAddressEntityStation(stationNumber);
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

		//TODO: Add logs

		return firestationResponseBody;
	}

	public StationNumber addFirestationMappingToASpecifiedAddress(Integer stationNumber, String address) {
		StationNumber stationNumberObject = new StationNumber();

		List<PersonEntity> personEntities = personRepository.findPersonEntityByAddressEntityEquals(address);

		for (PersonEntity person :
				personEntities) {
			AddressEntity addressEntity = person.getAddressEntity();
			addressEntity.setStation(stationNumber);
			person.setAddressEntity(addressEntity);
			//TODO: Add logs
		}
		stationNumberObject.setStationNumber(stationNumber);
		stationNumberObject.setAddress(address);
		stationNumberObject.setStatus(String.format(EStatusConstants.ADDED.getValue(), EObjectConstants.STATION.getObject()));
		//TODO: Add logs
		return stationNumberObject;
	}
}
