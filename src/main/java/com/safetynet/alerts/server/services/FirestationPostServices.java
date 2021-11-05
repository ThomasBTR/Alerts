package com.safetynet.alerts.server.services;

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
	PersonRepository personRepository;

	private static final Logger logger = LoggerFactory.getLogger(FirestationPostServices.class);

	public AddressesRsp addFirestations(Firestations body) {
		try {
			AddressesRsp addressesRsp = new AddressesRsp();


			for (Firestation1 firestation :
					body.getFirestations()) {
				List<PersonEntity> personEntities = personRepository.findPersonEntityByAddressEntityEquals(firestation.getAddress());

				for (PersonEntity person : personEntities) {
					AddressRsp addressRsp = null;
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
}
