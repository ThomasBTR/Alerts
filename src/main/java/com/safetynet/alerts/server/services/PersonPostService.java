package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IPersonMapper;
import io.swagger.model.PersonReq;
import io.swagger.model.PersonRsp;
import io.swagger.model.PersonsReq;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonPostService {

	@Autowired
	public PersonRepository personRepository;
	
	PersonPostService(){}
	
	public PersonPostService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(PersonPostService.class);

	public PersonsRsp addPersons(PersonsReq personsReq) {
		try{
			PersonsRsp personsRsp = new PersonsRsp();

			for (PersonReq person :
					personsReq.getPersons()) {
				PersonEntity personEntity = IPersonMapper.INSTANCE.personReqToPersonEntity(person);
				personRepository.save(personEntity);
				personsRsp.addPersonsItem(IPersonMapper.INSTANCE.personEntityToPersonRsp(personEntity));
			}
			return personsRsp;
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
			return null;
		}
	}

	public PersonRsp addPerson(PersonReq personReq) {
		try{
			PersonRsp personRsp;

			PersonEntity personEntity = IPersonMapper.INSTANCE.personReqToPersonEntity(personReq);
			personRepository.save(personEntity);
			personRsp = IPersonMapper.INSTANCE.personEntityToPersonRsp(personEntity);

			return personRsp;
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
			return null;
		}
	}
}
