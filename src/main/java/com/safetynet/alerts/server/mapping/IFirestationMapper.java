package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.server.database.entities.AddressEntity;
import com.safetynet.alerts.server.database.entities.PersonEntity;
import io.swagger.model.AddressRsp;
import io.swagger.model.PersonReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IFirestationMapper {

	IFirestationMapper INSTANCE = Mappers.getMapper(IFirestationMapper.class);

	@Mapping(source = "firstName", target = "firstName")
	@Mapping(source = "lastName", target = "lastName")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "AdressEntity.address", target = "address")
	@Mapping(source = "AdressEntity.city", target = "city")
	@Mapping(source = "AdressEntity.zip", target = "zip")
	List<PersonReq> personEntityListToFirestationPerson(List<PersonEntity> personEntities);

	AddressRsp addressRspFill(AddressEntity addressEntity);
}
