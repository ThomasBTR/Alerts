package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.constants.EObjectConstants;
import com.safetynet.alerts.server.constants.EStatusConstants;
import com.safetynet.alerts.server.database.entities.AddressEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IFirestationMapper;
import io.swagger.model.AddressRsp;
import io.swagger.model.AddressesRsp;
import io.swagger.model.Firestation1;
import io.swagger.model.Firestations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationPostServices {

	@Autowired
	public PersonRepository personRepository;

	public FirestationPostServices(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(FirestationPostServices.class);

	public AddressesRsp addFirestations(Firestations body) {
		logger.debug(EActionsProceedConstants.ADDING_MULTIPLE_FIRESTATIONS_START.getValue());
		try {
			AddressesRsp addressesRsp = new AddressesRsp();


			for (Firestation1 firestation :
					body.getFirestations()) {
				List<PersonEntity> personEntities = personRepository.findPersonEntityByAddressEntityEquals(firestation.getAddress());

				for (PersonEntity person : personEntities) {
					AddressRsp addressRsp;
					AddressEntity addressEntity = person.getAddressEntity();
					addressEntity.setStation(firestation.getStation());
					person.setAddressEntity(addressEntity);
					personRepository.save(person);
					addressRsp = IFirestationMapper.INSTANCE.addressRspFill(addressEntity);
					addressesRsp.addAddressesItem(addressRsp);
				}
			}
			return addressesRsp;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getStackTrace(), e);
			return null;
		}
	}

	public void addFirestationMappingToASpecifiedAddress(Integer stationNumber, String address) {
		logger.debug(EActionsProceedConstants.ADDING_FIRESTATION_START.getValue(), stationNumber, address);

		List<PersonEntity> personEntities = personRepository.findPersonEntityByAddressEntityEquals(address);
		logger.debug(EStatusConstants.DATA_RECEIVED_LIST.getValue(), EObjectConstants.PERSON.getObject(), personEntities.size());

		for (PersonEntity person :
				personEntities) {
			AddressEntity addressEntity = person.getAddressEntity();
			addressEntity.setStation(stationNumber);
			person.setAddressEntity(addressEntity);

		}

		logger.info(EActionsProceedConstants.ADDING_FIRESTATION_SUCCESS.getValue(), stationNumber, address);
	}

	public void updateFirestationMappingToASpecifiedAddress(int station, String address) {
		logger.debug(EActionsProceedConstants.UPDATING_FIRESTATION_START.getValue(), station, address);

		List<PersonEntity> personEntities = personRepository.findPersonEntityByAddressEntityEquals(address);
		logger.debug(EStatusConstants.DATA_RECEIVED_LIST.getValue(),EObjectConstants.PERSON.getObject(), personEntities.size());

		for (PersonEntity person :
				personEntities) {
			AddressEntity addressEntity = person.getAddressEntity();
			addressEntity.setStation(station);
			person.setAddressEntity(addressEntity);
		}
	}


	public void deleteFirestationMappingToASpecifiedAddress(int station, String address) {
		logger.debug(EActionsProceedConstants.DELETING_FIRESTATION_START.getValue(),station,address);
		try{
			List<PersonEntity> personEntities = personRepository.findPersonEntitiesByAddressEntityStation(station);
			for (PersonEntity person:
					personEntities) {
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setAddress(person.getAddressEntity().getAddress());
				addressEntity.setCity(person.getAddressEntity().getCity());
				addressEntity.setZip(person.getAddressEntity().getZip());
				addressEntity.setStation(0);
				person.setAddressEntity(addressEntity);
				personRepository.save(person);
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
		}
	}
}
