package com.safetynet.alerts.server.services;

import com.safetynet.alerts.database.entities.PersonEntity;
import com.safetynet.alerts.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IPersonMapper;
import io.swagger.model.PersonReq;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsPostService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	IPersonMapper personMapper;

	public PersonsRsp addPersons(PersonsReq personsReq) {

		PersonsRsp personsRsp = new PersonsRsp();

		for (PersonReq person :
				personsReq.getPersons()) {
			PersonEntity personEntity = personMapper.personReqToPersonEntity(person);
			personRepository.save(personEntity);
			personsRsp.addPersonsItem(personMapper.personEntityToPersonRsp(personEntity));
		}

		return personsRsp;
	}

}
