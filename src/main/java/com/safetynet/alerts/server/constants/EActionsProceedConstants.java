package com.safetynet.alerts.server.constants;

public enum EActionsProceedConstants {
	FIRESTATIONINFOS_FROMID_START("started process to get Persons Infos linked to Firestation #{}"),
	FIRESTATIONINFOS_FROMID_SUCCESS("Persons infos find from firestation #{}, with {} persons, {} childs and {} adults"),
	CHILDALERT_START("Started process to GET ChildAlert Object for the following address : {}."),
	CHILDALERT_SUCCESS("Succeed to create ChildAlert Object for the following address : {}."),
	CITYMAILINGLIST_START("Started process to GET CityMalingList Object for the following city : {}."),
	CITYMAILINGLIST_SUCCESS("Succeed to create ChildAlert Object for the following city : {}."),
	PHONEALERT_START("Started process to GET PhoneAlert Object for the following firestation : #{}."),
	PHONEALERT_SUCCESS("Succeed to create PhoneAlert Object for the following firestation : #{}."),
	FLOODSTATION_START("Started process to GET FloodStation Object for a list of {} firestations."),
	FLOODSTATION_SUCCESS("Succeed to create FloodStation Object for a list of {} firestations."),
	PERSONINFO_START("Started process to GET PersonInfo Object for the following person : {} {}."),
	PERSONINFO_SUCCESS("Succeed to create PersonInfo Object for the following person : {} {}."),
	FIRE_START("Started process to GET Fire Object for the following address : {}."),
	FIRE_SUCCESS("Succeed to create Fire Object for the following address: {}."),
	ADDING_FIRESTATION_START("Started process to add Firestation #{} to the following address : {}"),
	ADDING_FIRESTATION_SUCCESS("Firestation #{} added in database the following address : {}"),
	UPDATING_FIRESTATION_START("Started process to update Firestation #{} to the following address : {}"),
	UPDATING_FIRESTATION_SUCCESS("Succeed to update Firestation #{} to the following address : {}"),
	DELETING_FIRESTATION_START("Started process to delete Firestation #{} to the following address : {}"),
	DELETING_FIRESTATION_SUCCESS("Succeed to delete Firestation #{} to the following address : {}"),
	UPDATING_PERSON_START("Started process to update Person named {} {} in the database."),
	ADDING_PERSON_START("Started process to add Person named {} {} in the database."),
	ADDING_PERSON_SUCCESS("Succeed to add {} {} in the database."),
	UPDATING_PERSON_SUCCESS("Succeed to update {} {} in the database."),
	DELETING_PERSON_START("Started process to delete Person named {} {} in the database."),
	DELETING_PERSON_SUCCESS("Succeed to delete {} {} in the database."),
	ADDING_MULTIPLE_PERSONS_START("Started process to add multiple Persons in the database."),
	ADDING_MULTIPLE_PERSONS_SUCCESS("Succeed to add multiple Persons in the database.");


	private String value;

	EActionsProceedConstants(String value){
		this.value=value;
	}

	public String getValue(){
		return value;
	}

}
