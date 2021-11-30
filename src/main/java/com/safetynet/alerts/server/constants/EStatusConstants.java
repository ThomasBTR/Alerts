package com.safetynet.alerts.server.constants;

public enum EStatusConstants {
	
	
	ADDED("%s added to the database"),
	UPDATED("%s updated in database");


	private String value;

	EStatusConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
