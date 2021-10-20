package com.safetynet.alerts.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "allergenes")
public class AllergeneEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String allergene;

	public AllergeneEntity(String allergene) {
		this.allergene = allergene;
	}

	public AllergeneEntity() {
	}

}
