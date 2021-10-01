package com.safetynet.alerts.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="medicines")
public class MedicineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String medecineName;

	public MedicineEntity() {
	}

	public MedicineEntity(int id, String medecineName) {
		this.id = id;
		this.medecineName = medecineName;
	}
}