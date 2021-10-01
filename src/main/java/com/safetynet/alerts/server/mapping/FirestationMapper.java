package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.database.entities.AddressEntity;
import com.safetynet.alerts.database.entities.AllergeneEntity;
import com.safetynet.alerts.database.entities.MedicationEntity;
import com.safetynet.alerts.database.entities.PersonEntity;
import io.swagger.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FirestationMapper {

	AllergeneEntity allergeneEntity = new AllergeneEntity();
	AddressEntity addressEntity = new AddressEntity();
	PersonEntity personEntity = new PersonEntity();
	MedicationEntity MEDICINE_ENTITY = new MedicationEntity();


	FirestationMapper INSTANCE = Mappers.getMapper(FirestationMapper.class);

	@Mapping(source = "firstName", target = "firstName")
	@Mapping(source = "lastName", target = "lastName")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "AdressEntity.address", target = "address")
	@Mapping(source = "AdressEntity.city", target = "city")
	@Mapping(source = "AdressEntity.zip", target = "zip")
	List<Person> personEntityListToFirestationPerson(List<PersonEntity> personEntities);


}
