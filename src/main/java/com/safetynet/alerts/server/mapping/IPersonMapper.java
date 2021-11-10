package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.server.database.entities.AllergeneEntity;
import com.safetynet.alerts.server.database.entities.MedicationEntity;
import com.safetynet.alerts.server.database.entities.MedicineEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import io.swagger.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Mapper
public interface IPersonMapper {

	IPersonMapper INSTANCE = Mappers.getMapper(IPersonMapper.class);

	@Mapping(target = "lastName", source = "nameEntity.lastName")
	@Mapping(target = "firstName", source = "nameEntity.firstName")
	@Mapping(target = "address", source = "addressEntity")
	@Mapping(target = "medications", ignore = true)
	@Mapping(target = "allergies", ignore = true)
	PersonRsp personEntityToPersonRsp(PersonEntity personEntity);

	@Mapping(target = "lastName", source = "nameEntity.lastName")
	@Mapping(target = "firstName", source = "nameEntity.firstName")
	@Mapping(target = "address", source = "addressEntity")
	@Mapping(target = "medications", source = "medications", qualifiedByName = "medicationEntityToMedications")
	@Mapping(target = "allergies", source = "allergies", qualifiedByName = "allergiesRefractor")
	PersonRsp personEntityWithMedicationToPersonRsp(PersonEntity personEntity);

	@Mapping(target = "addressEntity", ignore = true)
	@Mapping(target = "nameEntity", ignore = true)
	@Mapping(target = "nameEntity.firstName", source = "firstName")
	@Mapping(target = "nameEntity.lastName", source = "lastName")
	@Mapping(target = "email", source = "email")
	@Mapping(target = "phone", source = "phone")
	@Mapping(target = "birthdate", ignore = true)
	@Mapping(target = "addressEntity.address", source = "address")
	@Mapping(target = "addressEntity.zip", source = "zip")
	@Mapping(target = "addressEntity.city", source = "city")
	@Mapping(target = "allergies", ignore = true)
	@Mapping(target = "medications", ignore = true)
	PersonEntity personReqToPersonEntity(PersonReq personReq);


	@Named("medicationEntityToMedications")
	default List<Medications> medicationEntityToMedications(List<MedicationEntity> medicationEntities) {
		List<Medications> medicationsList = new ArrayList<>();

		for (MedicationEntity medicationEntity:
		     medicationEntities) {
			io.swagger.model.Medications medications = new Medications();
			medications.setDosage(medicationEntity.getDosage());
			medications.setId(medicationEntity.getId());
			MedicineEntity medicineEntity = medicationEntity.getMedicineEntity();
			MedicationsMedicineEntity medicationsMedicineEntity = new MedicationsMedicineEntity();
			medicationsMedicineEntity.setMedicineName(medicineEntity.getMedecineName());
			medicationsMedicineEntity.setId(medicineEntity.getId());
			medications.setMedicineEntity(medicationsMedicineEntity);
			medicationsList.add(medications);
		}
		return medicationsList;
	}

	@Named("allergiesRefractor")
	default List<Allergies> allergiesRefractor (List<AllergeneEntity> allergeneEntities){
		List<Allergies> allergiesList = new ArrayList<>();
		for (AllergeneEntity allergene:
		     allergeneEntities) {
			Allergies allergie = new Allergies();
			allergie.setAllergene(allergene.getAllergene());
			allergie.setId(allergene.getId());
			allergiesList.add(allergie);
		}
		return allergiesList;
	}


}
