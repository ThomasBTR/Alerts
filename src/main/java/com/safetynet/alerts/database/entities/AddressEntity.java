package com.safetynet.alerts.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class AddressEntity {

	private String address;
	private String city;
	private String zip;
	private int station;

	public AddressEntity() {

	}

	public AddressEntity(String address, String city, String zip, int station) {
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.station = station;
	}

}
