package com.safetynet.alerts.server.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Comparator;

@Getter
@Setter
@Embeddable
public class AddressEntity implements Comparable<AddressEntity> {

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


	@Override
	public int compareTo(AddressEntity o) {
		return 0;
	}

	public static class Comparators {
		public static final Comparator<AddressEntity> ADDRESS = (AddressEntity person1, AddressEntity person2) -> person1.address.compareTo(person2.address);

	}

}
