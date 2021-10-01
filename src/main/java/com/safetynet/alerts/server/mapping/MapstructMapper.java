package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.database.entities.AddressEntity;
import com.safetynet.alerts.database.entities.AllergeneEntity;
import com.safetynet.alerts.database.entities.MedicationEntity;
import com.safetynet.alerts.database.entities.PersonEntity;
import io.swagger.model.Firestation;
import io.swagger.model.MedicalRecord;
import io.swagger.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapstructMapper {

	AllergeneEntity allergeneEntity = new AllergeneEntity();
	AddressEntity addressEntity = new AddressEntity();
	PersonEntity personEntity = new PersonEntity();
	MedicationEntity MEDICINE_ENTITY = new MedicationEntity();


	MapstructMapper INSTANCE = Mappers.getMapper(MapstructMapper.class);

	@Mapping(source = "firstName", target = "firstName")
	@Mapping(source = "lastName", target = "lastName")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "address", target = "address")
	@Mapping(source = "city", target = "city")
	@Mapping(source = "zip", target = "zip")
	PersonEntity personJsonToPersonEntity(Person personJson);


	@Mapping(source = "station", target = "station", qualifiedByName = "toto")
	AddressEntity firestationsToAddressEntity(Firestation firestationJson);


	@Mapping(source = "allergies", target = "allergene", qualifiedByName = "enrichAllergenEntityWithAllergies")
	AllergeneEntity medicalRecordtoAllergeneEntity(MedicalRecord medicalRecordJson);

	@Mapping(source = "birthdate", target = "birthdate", qualifiedByName = "enrichPersonEntityWithBirthdate")
	PersonEntity medicalRecordToPersonEntity(MedicalRecord medicalRecordJson);


	//Récupere la birthdate à partir du firstName/lastName
	@Named("enrichPersonEntityWithBirthdate")
	default String getPersonEntity(String birthdate) {
		return null;
	}

	//Récupère la station à partir de l'adresse
	@Named(value = "toto")
	default int getAddressEntity(int station) {
		return 0;
	}


	//Récupère la liste d'allergies
	@Named("enrichAllergenEntityWithAllergies")
	default String getAllergeneEntity(String[] allergies) {
		return null;
	}


}
