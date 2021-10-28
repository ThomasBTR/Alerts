package com.safetynet.alerts.server.services;

import com.safetynet.alerts.database.entities.PersonEntity;
import com.safetynet.alerts.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IPersonMapper;
import io.swagger.model.PersonReq;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsPostService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	IPersonMapper personMapper;

	private static final Logger logger = LogManager.getLogger(PersonsPostService.class);

	public PersonsRsp addPersons(PersonsReq personsReq) {
		try{
			PersonsRsp personsRsp = new PersonsRsp();

			for (PersonReq person :
					personsReq.getPersons()) {
				PersonEntity personEntity = personMapper.personReqToPersonEntity(person);
				personRepository.save(personEntity);
				personsRsp.addPersonsItem(personMapper.personEntityToPersonRsp(personEntity));
				return personsRsp;
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
			return null;
		}
		return null;
	}

}
