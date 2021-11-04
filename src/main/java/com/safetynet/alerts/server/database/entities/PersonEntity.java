package com.safetynet.alerts.server.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "persons")
public class PersonEntity {

	@EmbeddedId
	private NameEntity nameEntity;
	private LocalDate birthdate;
	private String email;
	private String phone;
	@Embedded
	private AddressEntity addressEntity;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "allergies", joinColumns = {
			@JoinColumn(name = "firstName", referencedColumnName = "firstName", insertable = false, updatable = false),
			@JoinColumn(name = "lastName", referencedColumnName = "lastName", insertable = false, updatable = false)
	})
	private List<AllergeneEntity> allergies;
	@OneToMany(mappedBy = "personEntity")
	private List<MedicationEntity> medications;

	public PersonEntity() {

	}

	public PersonEntity(NameEntity nameEntity, LocalDate birthdate, String email, String phone, AddressEntity addressEntity, List<AllergeneEntity> allergies, List<MedicationEntity> medications) {
		this.nameEntity = nameEntity;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.addressEntity = addressEntity;
		this.allergies = allergies;
		this.medications = medications;
	}
}
