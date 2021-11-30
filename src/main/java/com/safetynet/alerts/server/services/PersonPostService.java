package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IPersonMapper;
import io.swagger.model.PersonReq;
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
		logger.debug(EActionsProceedConstants.ADDING_MULTIPLE_PERSONS_SUCCESS.getValue());
		try{
			PersonsRsp personsRsp = new PersonsRsp();

			for (PersonReq person :
					personsReq.getPersons()) {
				PersonEntity personEntity = IPersonMapper.INSTANCE.personReqToPersonEntity(person);
				personRepository.save(personEntity);
				logger.debug(EActionsProceedConstants.ADDING_PERSON_SUCCESS.getValue(),person.getFirstName(),person.getLastName());
				personsRsp.addPersonsItem(IPersonMapper.INSTANCE.personEntityToPersonRsp(personEntity));
			}
			return personsRsp;
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
			return null;
		}
	}

	public void addPerson(PersonReq personReq) {
		logger.debug(EActionsProceedConstants.ADDING_PERSON_START.getValue(),personReq.getFirstName(),personReq.getLastName());
		try{
			PersonEntity personEntity = IPersonMapper.INSTANCE.personReqToPersonEntity(personReq);
			personRepository.save(personEntity);
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
		}
	}

	public void updatePerson(PersonReq body) {
		logger.debug(EActionsProceedConstants.UPDATING_PERSON_START.getValue(),body.getFirstName(), body.getLastName());
		try{
			PersonEntity personEntity = IPersonMapper.INSTANCE.personReqToPersonEntity(body);
			personRepository.save(personEntity);
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
		}
	}

	public void deletePerson(String firstName, String lastName) {
		logger.debug(EActionsProceedConstants.DELETING_PERSON_START.getValue(),firstName,lastName);
		try{
			personRepository.delete(personRepository.findPersonEntityByNameEntityLike(firstName,lastName));
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
		}
	}


}
