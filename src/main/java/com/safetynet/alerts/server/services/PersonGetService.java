package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import io.swagger.model.Child;
import io.swagger.model.ChildAlert;
import io.swagger.model.PersonInfo1;
import io.swagger.model.PhoneAlert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonGetService {

	@Autowired
	public PersonRepository personRepository;

	private static final Logger logger = LoggerFactory.getLogger(PersonGetService.class);

	public PersonGetService(){}

	public PersonGetService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	public ChildAlert getChildrenInfoFromAddress(String address) {
		try{
			ChildAlert childAlert = new ChildAlert();

			List<PersonEntity> personEntityList = personRepository.findPersonEntityByAddressEntityEquals(address);
			List<PersonInfo1> personInfo1List = new ArrayList<>();

			for (PersonEntity person :
				personEntityList) {
				if(person.getBirthdate().isAfter(LocalDate.now().minusYears(18))){
					Child child = new Child();
					child.setFirstName(person.getNameEntity().getFirstName());
					child.setLastName(person.getNameEntity().getLastName());
					child.setAge(getAge(person.getBirthdate()));
					childAlert.addChildItem(child);
				} else {
					 PersonInfo1 personInfo1 = new PersonInfo1();
					 personInfo1.setFirstName(person.getNameEntity().getFirstName());
					 personInfo1.setLastName(person.getNameEntity().getLastName());
					 personInfo1.setPhone(person.getPhone());
					 personInfo1List.add(personInfo1);
				}
			}

			for (Child child:
			     childAlert.getChild()) {
				child.setPersons(personInfo1List);
			}


			return childAlert;
		}catch(Exception e){
			logger.error(e.getMessage(),e.getStackTrace(),e);
			return null;
		}
	}

	public String getAge(LocalDate birthDate){
		String age = null;
		if (birthDate != null) {
			return String.valueOf(Period.between(birthDate, LocalDate.now()).getYears());
		} else {
			return null;
		}
	}

	public PhoneAlert getPhoneAlert(int station) {

		PhoneAlert phoneAlert = new PhoneAlert();

		List<PersonEntity> personEntityList = personRepository.findPersonEntitiesByAddressEntityContainingSpecificStation(station);

		for (PersonEntity person:
		     personEntityList) {
			phoneAlert.addPhonesItem(person.getPhone());
		}

		return phoneAlert;
	}
}
