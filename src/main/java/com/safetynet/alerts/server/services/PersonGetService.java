package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.database.entities.AllergeneEntity;
import com.safetynet.alerts.server.database.entities.MedicationEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import io.swagger.model.*;
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

	public PersonGetService() {
	}

	public PersonGetService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public ChildAlert getChildrenInfoFromAddress(String address) {
		try {
			ChildAlert childAlert = new ChildAlert();

			List<PersonEntity> personEntityList = personRepository.findPersonEntityByAddressEntityEquals(address);
			List<PersonInfo1> personInfo1List = new ArrayList<>();

			for (PersonEntity person :
					personEntityList) {
				if (person.getBirthdate().isAfter(LocalDate.now().minusYears(18))) {
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

			for (Child child :
					childAlert.getChild()) {
				child.setPersons(personInfo1List);
			}


			return childAlert;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getStackTrace(), e);
			return null;
		}
	}

	public String getAge(LocalDate birthDate) {
		if (birthDate != null) {
			return String.valueOf(Period.between(birthDate, LocalDate.now()).getYears());
		} else {
			return null;
		}
	}

	public PhoneAlert getPhoneAlert(int station) {

		PhoneAlert phoneAlert = new PhoneAlert();

		List<PersonEntity> personEntityList = personRepository.findPersonEntitiesByAddressEntityContainingSpecificStation(station);

		for (PersonEntity person :
				personEntityList) {
			phoneAlert.addPhonesItem(person.getPhone());
		}

		return phoneAlert;
	}

	public Fire getFireBody(String address) {
		Fire fire = new Fire();

		List<PersonEntity> personEntityList = personRepository.findPersonEntityByAddressEntityEquals(address);

		Integer adultCount = 0;
		Integer childCount = 0;

		for (PersonEntity person :
				personEntityList) {
			Phone phone = new Phone();
			phone.setPhone(person.getPhone());
			fire.addPhonesItem(phone);

			if (person.getBirthdate().isAfter(LocalDate.now().minusYears(18))) {
				++childCount;
			} else {
				++adultCount;
			}

		}

		fire.setAdultCount(adultCount);
		fire.setChildCount(childCount);

		return fire;

	}

	public FloodStation getFloodStation(List<Integer> firestationList) {
		FloodStation floodStation = new FloodStation();

		for (Integer station :
				firestationList) {
			List<PersonEntity> personEntityList = personRepository.findPersonEntitiesByAddressEntityContainingSpecificStation(station);

			personEntityList.sort(PersonEntity.Comparators.ADDRESS);

			FloodStation1 floodStation1 = new FloodStation1();

			for (PersonEntity person :
					personEntityList) {
				if (person.getAddressEntity().getAddress().equals(floodStation1.getAddress())) {
					floodStation1 = new FloodStation1();
					floodStation1.setAddress(person.getAddressEntity().getAddress());
					floodStation1.setCity(person.getAddressEntity().getCity());
					floodStation1.setZip(person.getAddressEntity().getZip());
				}

				floodStation1.setPersonsInfo(createFloodstationPerson(person));
				floodStation.addAddressesItem(floodStation1);
			}
		}


		return floodStation;
	}

	public PersonInfo getPersonsInfos(String firstName, String lastName) {

		PersonEntity personEntity = personRepository.findPersonEntityByNameEntityLike(firstName,lastName);

		Personinfos personinfos = new Personinfos();

		personinfos.setAge(getAge(personEntity.getBirthdate()));
		personinfos.setAllergies(getAllergiesInfo(personEntity.getAllergies()));
		personinfos.setMedications(getpersonsInfoMedications(personEntity.getMedications()));
		personinfos.setFirstName(firstName);
		personinfos.setLastName(lastName);
		personinfos.setEmail(personEntity.getEmail());

		PersonInfo personInfo = new PersonInfo();
		personInfo.addPersonsinfosItem(personinfos);

		return personInfo;
	}


	private FloodStation1PersonsInfo createFloodstationPerson(PersonEntity person) {
		FloodStation1PersonsInfo floodStation1PersonsInfo = new FloodStation1PersonsInfo();

		FloodstationPersonsInfo personsInfo = new FloodstationPersonsInfo();
		personsInfo.setFirstName(person.getNameEntity().getFirstName());
		personsInfo.setLastName(person.getNameEntity().getLastName());
		personsInfo.setPhone(person.getPhone());
		personsInfo.setAllergies(getAllergiesInfo(person.getAllergies()));
		personsInfo.setMedications(getpersonsInfoMedications(person.getMedications()));
		floodStation1PersonsInfo.setPersons(personsInfo);

		return floodStation1PersonsInfo;
	}

	private PersoninfosMedications getpersonsInfoMedications(List<MedicationEntity> medications) {
		PersoninfosMedications personsInfoMedications = new PersoninfosMedications();
		for (MedicationEntity medicationEntity :
				medications) {
			Medications medicationsInfos = new Medications();
			medicationsInfos.setId(medicationEntity.getId());
			medicationsInfos.setDosage(medicationEntity.getDosage());

			MedicationsMedicineEntity medicationsMedicineEntity = new MedicationsMedicineEntity();
			medicationsMedicineEntity.setId(medicationEntity.getMedicineEntity().getId());
			medicationsMedicineEntity.setMedicineName(medicationEntity.getMedicineEntity().getMedecineName());

			medicationsInfos.setMedicineEntity(medicationsMedicineEntity);
			personsInfoMedications.setMedications(medicationsInfos);
		}
		return personsInfoMedications;
	}

	private PersoninfosAllergies getAllergiesInfo(List<AllergeneEntity> allergies) {
		PersoninfosAllergies personsInfoAllergies = new PersoninfosAllergies();
		for (AllergeneEntity allergeneEntity :
				allergies) {
			Allergies allergiesinfo = new Allergies();
			allergiesinfo.setAllergene(allergeneEntity.getAllergene());
			allergiesinfo.setId(allergeneEntity.getId());
			personsInfoAllergies.setAllegies(allergiesinfo);
		}

		return personsInfoAllergies;
	}


	public CityMailingList getCityMailingList(String city) {
		CityMailingList cityMailingList = new CityMailingList();

		List<PersonEntity> personEntities = personRepository.findPersonEntitiesByAddressEntityContainingCity(city);

		for (PersonEntity person:
			personEntities) {
			cityMailingList.addEmailsItem(person.getEmail());
		}

		return cityMailingList;
	}
}
