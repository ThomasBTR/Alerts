package com.safetynet.alerts.server.constants;

public enum EStatusConstants {
	
	
	ADDED("%s added to the database"),
	UPDATED("%s updated in database"),
	DELETED("%s deleted form the database"),
	DATA_RECEIVED("{} data received form the database with {} entity(ies).");


	private String value;

	EStatusConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
