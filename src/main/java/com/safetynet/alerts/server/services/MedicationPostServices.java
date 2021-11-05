package com.safetynet.alerts.server.services;

import com.safetynet.alerts.server.database.entities.AllergeneEntity;
import com.safetynet.alerts.server.database.entities.MedicationEntity;
import com.safetynet.alerts.server.database.entities.MedicineEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
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
	PersonRepository personRepository;

	private static final Logger logger = LoggerFactory.getLogger(MedicationPostServices.class);

	public PersonsRsp addMedications(Medicalrecords body) {
		try {
			PersonsRsp personRspList = new PersonsRsp();
			for (MedicalRecord medicalrecord :
					body.getMedicalrecords()) {
				PersonEntity person = personRepository.findPersonEntityByNameEntityLike(medicalrecord.getFirstName(), medicalrecord.getLastName());
				person.setBirthdate(getBirthDate(medicalrecord.getBirthdate()));

				person.setMedications(getMedicationsEntities(medicalrecord,person));

				person.setAllergies(getAllergies(medicalrecord));

				personRepository.save(person);

				PersonRsp personRsp = IPersonMapper.INSTANCE.personEntityToPersonRsp(person);

				personRspList.addPersonsItem(personRsp);
			}
			return personRspList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getStackTrace(), e);
			return null;
		}
	}

	private LocalDate getBirthDate(String birthdate) {
		return LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

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
}
