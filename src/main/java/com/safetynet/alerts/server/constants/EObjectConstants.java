package com.safetynet.alerts.server.constants;

public enum EObjectConstants {
	STATION("Station"),
	FIRESTATION("Firestation"),
	PERSON("Person");

	private final String object;

	EObjectConstants(String object) {
		this.object = object;
	}

	public String getObject(){
		return object;
	}

}
