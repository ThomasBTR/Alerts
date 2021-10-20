package com.safetynet.alerts.server.mapping;

import com.safetynet.alerts.database.entities.PersonEntity;
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


	@Mapping(target = "address", ignore = true)
	@Mapping(target = "medications", ignore = true)
	PersonRsp personEntityToPersonRsp(PersonEntity personEntity);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "email", source = "email")
	@Mapping(target = "phone", source = "phone")
	@Mapping(target = "birthdate", ignore = true)
	@Mapping(target = "addressEntity", ignore = true)
	@Mapping(target = "allergies", ignore = true)
	@Mapping(target = "medications", ignore = true)
	PersonEntity personReqToPersonEntity(PersonReq personReq);


}
