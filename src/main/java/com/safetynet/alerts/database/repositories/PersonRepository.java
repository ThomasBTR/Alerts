package com.safetynet.alerts.database.repositories;

import com.safetynet.alerts.database.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

	@Query("SELECT p from PersonEntity p WHERE p.addressEntity.station =:variable")
	List<PersonEntity> findPersonEntitiesByAddressEntityStation(@Param("variable") int stationNumber);


}
