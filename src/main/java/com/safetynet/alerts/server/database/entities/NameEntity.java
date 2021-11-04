package com.safetynet.alerts.server.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class NameEntity implements Serializable {

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;

	public NameEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public NameEntity(){}

}
