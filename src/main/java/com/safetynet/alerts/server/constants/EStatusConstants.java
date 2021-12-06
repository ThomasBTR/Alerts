package com.safetynet.alerts.server.constants;

public enum EStatusConstants {
	
	
	ADDED("%s added to the database"),
	UPDATED("%s updated in database"),
	DELETED("%s deleted form the database"),
	DATA_RECEIVED_LIST("{} data received form the database with {} entity(ies)."),
	DATA_RECEIVED_SOLO("{} entity received form the database.");



	private final String value;

	EStatusConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
