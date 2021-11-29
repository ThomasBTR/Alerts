package com.safetynet.alerts.server.database.repositories;

import com.safetynet.alerts.server.database.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

	@Query("SELECT p from PersonEntity p WHERE p.addressEntity.station =:variable")
	List<PersonEntity> findPersonEntitiesByAddressEntityStation(@Param("variable") int stationNumber);

	@Query("SELECT p from PersonEntity p WHERE p.nameEntity.firstName =:var1 AND p.nameEntity.lastName =:var2")
	PersonEntity findPersonEntityByNameEntityLike(@Param("var1")String firstName, @Param("var2") String lastName);

	@Query("SELECT p FROM PersonEntity p WHERE p.addressEntity.address =:variable")
	List<PersonEntity> findPersonEntityByAddressEntityEquals(@Param("variable")String address);

	@Query("SELECT p FROM PersonEntity p WHERE p.addressEntity.station =:variable")
	List<PersonEntity> findPersonEntitiesByAddressEntityContainingSpecificStation(@Param("variable")int station);

	@Query("SELECT p FROM PersonEntity p WHERE p.addressEntity.city =:variable")
	List<PersonEntity> findPersonEntitiesByAddressEntityContainingCity(@Param("variable")String city);
}
