package com.safetynet.alerts.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MedicationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private PersonEntity personEntity;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private MedicineEntity medicineEntity;
	private int dosage;


	public MedicationEntity(PersonEntity personEntity, MedicineEntity medicineEntity, int dosage) {
		this.personEntity = personEntity;
		this.medicineEntity = medicineEntity;
		this.dosage = dosage;
	}

	public MedicationEntity() {
	}
}




