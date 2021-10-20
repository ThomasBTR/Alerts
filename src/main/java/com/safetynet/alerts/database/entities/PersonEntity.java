package com.safetynet.alerts.database.entities;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private String email;
	private String phone;
	@Embedded
	private AddressEntity addressEntity;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "allergies", joinColumns = @JoinColumn(name = "person_id"))
	private List<AllergeneEntity> allergies;
	@OneToMany(mappedBy = "personEntity")
	private List<MedicationEntity> medications;

	public PersonEntity() {

	}

	public PersonEntity(String firstName, String lastName, LocalDate birthdate, String email, String phone, AddressEntity addressEntity, List<AllergeneEntity> allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.addressEntity = addressEntity;
		this.allergies = allergies;
	}
}
