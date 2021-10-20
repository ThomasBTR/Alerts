package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.database.entities.PersonEntity;
import io.swagger.model.PersonReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FirestationMapper {

	FirestationMapper INSTANCE = Mappers.getMapper(FirestationMapper.class);

	@Mapping(source = "firstName", target = "firstName")
	@Mapping(source = "lastName", target = "lastName")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "AdressEntity.address", target = "address")
	@Mapping(source = "AdressEntity.city", target = "city")
	@Mapping(source = "AdressEntity.zip", target = "zip")
	List<PersonReq> personEntityListToFirestationPerson(List<PersonEntity> personEntities);


}
