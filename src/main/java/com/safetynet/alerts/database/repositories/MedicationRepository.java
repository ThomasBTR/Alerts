package com.safetynet.alerts.database.repositories;

import com.safetynet.alerts.database.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {

	@Query("SELECT m from MedicationEntity m")
	List<MedicationEntity> findAllMedications();

	@Query("SELECT m from MedicationEntity m WHERE m.medicineEntity.medecineName =:variable")
	MedicationEntity findMedicationEntityByMedicineEntity(@Param("variable") String medicine);

	@Query("SELECT m from MedicationEntity m WHERE m.medicineEntity.medecineName LIKE %:variable%")
	MedicationEntity findMedicationEntityByMedicineEntityLike(@Param("variable") String medicine);
}
