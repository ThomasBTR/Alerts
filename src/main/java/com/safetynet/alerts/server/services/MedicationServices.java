package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.constants.EActionsProceedConstants;
import com.safetynet.alerts.server.constants.EObjectConstants;
import com.safetynet.alerts.server.constants.EStatusConstants;
import com.safetynet.alerts.server.database.entities.AllergeneEntity;
import com.safetynet.alerts.server.database.entities.MedicationEntity;
import com.safetynet.alerts.server.database.entities.MedicineEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import com.safetynet.alerts.server.database.repositories.AllergeneRepository;
import com.safetynet.alerts.server.database.repositories.MedicationRepository;
import com.safetynet.alerts.server.database.repositories.PersonRepository;
import com.safetynet.alerts.server.mapping.IPersonMapper;
import io.swagger.model.MedicalRecord;
import io.swagger.model.Medicalrecords;
import io.swagger.model.PersonRsp;
import io.swagger.model.PersonsRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationServices {

	@Autowired
	public PersonRepository personRepository;

	@Autowired
	public MedicationRepository medicationRepository;

	@Autowired
	public AllergeneRepository allergeneRepository;

	public MedicationServices(PersonRepository personRepository, MedicationRepository medicationRepository, AllergeneRepository allergeneRepository){
		this.medicationRepository = medicationRepository;
		this.allergeneRepository = allergeneRepository;
		this.personRepository = personRepository;
	}


	private static final Logger logger = LoggerFactory.getLogger(MedicationServices.class);

	public PersonsRsp addMedications(Medicalrecords body) {
		try {
			PersonsRsp personRspList = new PersonsRsp();
			for (MedicalRecord medicalrecord :
					body.getMedicalrecords()) {
				PersonEntity person = addMedication(medicalrecord);

				PersonRsp personRsp = IPersonMapper.INSTANCE.personEntityWithMedicationToPersonRsp(person);

				personRspList.addPersonsItem(personRsp);
			}
			return personRspList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getStackTrace(), e);
			return null;
		}
	}

	public PersonEntity addMedication(MedicalRecord medicalrecord) {
		logger.info(EActionsProceedConstants.ADDING_MEDICALRECORD_START.getValue(), medicalrecord.getFirstName(), medicalrecord.getLastName());
		PersonEntity person = personRepository.findPersonEntityByNameEntityLike(medicalrecord.getFirstName(), medicalrecord.getLastName());
		logger.debug(EStatusConstants.DATA_RECEIVED_SOLO.getValue(), EObjectConstants.PERSON.getObject());


		person.setBirthdate(getBirthDate(medicalrecord.getBirthdate()));

		List<MedicationEntity> medicationEntities = getMedicationsEntities(medicalrecord,person);
		medicationEntities = medicationRepository.saveAll(medicationEntities);
		person.setMedications(medicationEntities);

		List<AllergeneEntity> allergeneEntities = getAllergies(medicalrecord);
		allergeneEntities = allergeneRepository.saveAll(allergeneEntities);
		person.setAllergies(allergeneEntities);
		person = personRepository.save(person);
		return person;
	}




	private LocalDate getBirthDate(String birthdate) {
		return LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

	}

	private List<AllergeneEntity> getAllergies(MedicalRecord medicalrecord) {
		List<AllergeneEntity> allergeneEntities = new ArrayList<>();

		for (String allergene :
				medicalrecord.getAllergies()) {
			AllergeneEntity allergeneEntity = getAllergie(allergene);
			allergeneEntities.add(allergeneEntity);
		}

		return allergeneEntities;

	}

	private AllergeneEntity getAllergie(String allergene) {
		AllergeneEntity allergeneEntity = new AllergeneEntity();
		allergeneEntity.setAllergene(allergene);
		return allergeneEntity;
	}

	private List<MedicationEntity> getMedicationsEntities (MedicalRecord medicalrecord, PersonEntity personEntity){
		List<MedicationEntity> medicationEntities = new ArrayList<>();
		for (String medications : medicalrecord.getMedications()) {
			MedicationEntity medicationEntity = getMedicationsEntity(medications, personEntity);
			medicationEntities.add(medicationEntity);
		}
		return medicationEntities;
	}

	private MedicationEntity getMedicationsEntity(String medications, PersonEntity personEntity) {
		MedicationEntity medicationEntity = new MedicationEntity();
		MedicineEntity medicineEntity = new MedicineEntity();

		String[] arr = medications.split(":");
		medicineEntity.setMedecineName(arr[0]);
		medicationEntity.setMedicineEntity(medicineEntity);

		String[] all = arr[1].split("mg");
		medicationEntity.setDosage(Integer.parseInt(all[0]));
		medicationEntity.setPersonEntity(personEntity);
		return medicationEntity;
	}


}
