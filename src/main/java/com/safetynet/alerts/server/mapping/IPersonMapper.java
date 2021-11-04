package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.server.database.entities.PersonEntity;
import io.swagger.model.PersonReq;
import io.swagger.model.PersonRsp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface IPersonMapper {

	IPersonMapper INSTANCE = Mappers.getMapper(IPersonMapper.class);

	@Mapping(target = "lastName", source = "nameEntity.lastName")
	@Mapping(target = "firstName", source = "nameEntity.firstName")
	@Mapping(target = "address", source = "addressEntity" )
	@Mapping(target = "medications", ignore = true)
	@Mapping(target = "allergies", ignore = true)
	PersonRsp personEntityToPersonRsp(PersonEntity personEntity);

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


}
