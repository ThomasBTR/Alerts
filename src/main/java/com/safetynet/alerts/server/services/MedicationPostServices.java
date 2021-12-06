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
public class MedicationPostServices {

	@Autowired
	public PersonRepository personRepository;

	@Autowired
	public MedicationRepository medicationRepository;

	@Autowired
	public AllergeneRepository allergeneRepository;

	public MedicationPostServices(PersonRepository personRepository, MedicationRepository medicationRepository, AllergeneRepository allergeneRepository){
		this.medicationRepository = medicationRepository;
		this.allergeneRepository = allergeneRepository;
		this.personRepository = personRepository;
	}


	private static final Logger logger = LoggerFactory.getLogger(MedicationPostServices.class);

	public PersonsRsp addMedicalRecords(Medicalrecords body) {
		logger.debug(EActionsProceedConstants.ADDING_MULTIPLE_MEDICAL_RECORDS_START.getValue());
		try {
			PersonsRsp personRspList = new PersonsRsp();
			for (MedicalRecord medicalrecord :
					body.getMedicalrecords()) {
				PersonEntity person = personRepository.findPersonEntityByNameEntityLike(medicalrecord.getFirstName(), medicalrecord.getLastName());
				logger.debug(EStatusConstants.DATA_RECEIVED_SOLO.getValue(), EObjectConstants.PERSON);
				person.setBirthdate(getBirthDate(medicalrecord.getBirthdate()));

				List<MedicationEntity> medicationEntities = getMedicationsEntities(medicalrecord,person);
				medicationEntities = medicationRepository.saveAll(medicationEntities);
				person.setMedications(medicationEntities);

				List<AllergeneEntity> allergeneEntities = getAllergies(medicalrecord);
				allergeneEntities = allergeneRepository.saveAll(allergeneEntities);
				person.setAllergies(allergeneEntities);


				person = personRepository.save(person);

				PersonRsp personRsp = IPersonMapper.INSTANCE.personEntityWithMedicationToPersonRsp(person);

				personRspList.addPersonsItem(personRsp);
			}
			return personRspList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getStackTrace(), e);
			return null;
		}
	}

	private LocalDate getBirthDate(String birthdate) {
		return LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

	}

	private List<AllergeneEntity> getAllergies(MedicalRecord medicalrecord) {
		List<AllergeneEntity> allergeneEntities = new ArrayList<>();

		for (String allergene :
				medicalrecord.getAllergies()) {
			AllergeneEntity allergeneEntity = new AllergeneEntity();
			allergeneEntity.setAllergene(allergene);
			allergeneEntities.add(allergeneEntity);
		}

		return allergeneEntities;

	}

	private List<MedicationEntity> getMedicationsEntities (MedicalRecord medicalrecord, PersonEntity personEntity){
		List<MedicationEntity> medicationEntities = new ArrayList<>();
		for (String medications : medicalrecord.getMedications()) {
			MedicationEntity medicationEntity = new MedicationEntity();
			MedicineEntity medicineEntity = new MedicineEntity();

			String[] arr = medications.split(":");
			medicineEntity.setMedecineName(arr[0]);
			medicationEntity.setMedicineEntity(medicineEntity);

			String[] all = arr[1].split("mg");
			medicationEntity.setDosage(Integer.parseInt(all[0]));
			medicationEntity.setPersonEntity(personEntity);
			medicationEntities.add(medicationEntity);
		}
		return medicationEntities;
	}

	public void addMedicalRecord(MedicalRecord medicalRecord){
		logger.debug(EActionsProceedConstants.ADDING_MEDICAL_RECORD_START.getValue(), medicalRecord.getFirstName(), medicalRecord.getLastName());
		PersonEntity person = personRepository.findPersonEntityByNameEntityLike(medicalRecord.getFirstName(), medicalRecord.getLastName());
		logger.debug(EStatusConstants.DATA_RECEIVED_SOLO.getValue(), EObjectConstants.PERSON);
		person.setBirthdate(getBirthDate(medicalRecord.getBirthdate()));

		List<MedicationEntity> medicationEntities = getMedicationsEntities(medicalRecord,person);
		medicationEntities = medicationRepository.saveAll(medicationEntities);
		person.setMedications(medicationEntities);

		List<AllergeneEntity> allergeneEntities = getAllergies(medicalRecord);
		allergeneEntities = allergeneRepository.saveAll(allergeneEntities);
		person.setAllergies(allergeneEntities);
		personRepository.save(person);
	}

	public void updateMedicalRecord(String firstName, String lastName, MedicalRecord medicalRecord){
		logger.debug(EActionsProceedConstants.UPDATING_MEDICAL_RECORD_START.getValue(), medicalRecord.getFirstName(), medicalRecord.getLastName());
		PersonEntity person = personRepository.findPersonEntityByNameEntityLike(firstName, lastName);
		logger.debug(EStatusConstants.DATA_RECEIVED_SOLO.getValue(), EObjectConstants.PERSON);
		person.setBirthdate(getBirthDate(medicalRecord.getBirthdate()));

		List<MedicationEntity> medicationEntities = getMedicationsEntities(medicalRecord,person);
		medicationEntities = medicationRepository.saveAll(medicationEntities);
		person.setMedications(medicationEntities);

		List<AllergeneEntity> allergeneEntities = getAllergies(medicalRecord);
		allergeneEntities = allergeneRepository.saveAll(allergeneEntities);
		person.setAllergies(allergeneEntities);
		personRepository.save(person);
	}

	public void deleteMedicalRecord(String firstName, String lastName) {
		logger.debug(EActionsProceedConstants.DELETING_MEDICAL_RECORD_START.getValue(), firstName, lastName);
		PersonEntity person = personRepository.findPersonEntityByNameEntityLike(firstName, lastName);
		logger.debug(EStatusConstants.DATA_RECEIVED_SOLO.getValue(), EObjectConstants.PERSON);
		person.setBirthdate(LocalDate.now());

		List<MedicationEntity> medicationEntities = new ArrayList<>();
		medicationEntities = medicationRepository.saveAll(medicationEntities);
		person.setMedications(medicationEntities);

		List<AllergeneEntity> allergeneEntities = new ArrayList<>();
		allergeneEntities = allergeneRepository.saveAll(allergeneEntities);
		person.setAllergies(allergeneEntities);
		personRepository.save(person);
	}
}
