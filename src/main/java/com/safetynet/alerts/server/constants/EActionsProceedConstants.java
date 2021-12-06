package com.safetynet.alerts.server.constants;

public enum EActionsProceedConstants {
	FIRESTATIONINFOS_FROMID_START("started process to get Persons Infos linked to Firestation #{}"),
	FIRESTATIONINFOS_FROMID_SUCCESS("Persons infos find from firestation #{}, with {} persons, {} childs and {} adults"),
	FIRESTATIONINFOS_FROMID_ERROR("Error processing FirestationInfos."),
	PERSONINFO_START("started process to get PersonsInfos linked to {} {}"),
	PERSONINFO_SUCCESS("Persons infos retreived for {} {}."),
	PERSONINFO_ERROR("Error processing PersonInfo."),
	COMMUNITYEMAIL_START("started process to get CommunityEmail object linked to the following city : {}"),
	COMMUNITYEMAIL_SUCCESS("Retreived CommunityMail object linked to the following city : {}."),
	COMMUNITYEMAIL_ERROR("Error processing CommunityMail."),
	CHILDALERT_START("started process to get ChildAlert Object for the following address :{}"),
	CHILDALERT_SUCCESS("ChildAlert object created for the following address : {}"),
	CHILDALERT_ERROR("Error processing ChildAlert Object."),
	PHONEALERT_START("started process to get PhoneAlert Object for the following Firestation #{}"),
	PHONEALERT_SUCCESS("PhoneAlert object created for the following Firestation #{}"),
	PHONEALERT_ERROR("Error processing PhoneAlert Object."),
	FIREBODY_START("started process to get Fire Object for the following address :{}"),
	FIREBODY_SUCCESS("Fire object created for the following address :{}"),
	FIREBODY_ERROR("Error processing Fire Object."),
	ADDING_FIRESTATION_START("Started process to add Firestation #{} to the following address : {}"),
	ADDING_FIRESTATION_SUCCESS("Firestation #{} added in database the following address : {}"),
	ADDING_FIRESTATION_ERROR("Error processing Firestation - add."),
	UPDATING_FIRESTATION_START("Started process to update Firestation #{} to the following address : {}"),
	UPDATING_FIRESTATION_SUCCESS("Firestation #{} updated in database the following address : {}"),
	UPDATING_FIRESTATION_ERROR("Error processing Firestation - update."),
	DELETING_FIRESTATION_START("Started process to delete Firestation #{} to the following address : {}"),
	DELETING_FIRESTATION_SUCCESS("Firestation #{} deleted in database the following address : {}"),
	DELETING_FIRESTATION_ERROR("Error processing Firestation - delete."),
	ADDING_PERSON_START("Started process to add Person named {} {} in the database."),
	ADDING_PERSON_SUCCESS("Succeed to add {} {} in the database."),
	ADDING_PERSON_ERROR("Error processing Person - add."),
	UPDATING_PERSON_START("Started process to update Person named {} {} in the database."),
	UPDATING_PERSON_SUCCESS("Succeed to update {} {} in the database."),
	UPDATING_PERSON_ERROR("Error processing Person - update."),
	DELETING_PERSON_START("Started process to delete Person named {} {} in the database."),
	DELETING_PERSON_SUCCESS("Succeed to delete {} {} in the database."),
	DELETING_PERSON_ERROR("Error processing Person - delete."),
	ADDING_MULTIPLE_PERSONS_START("Started process to add multiple Persons in the database."),
	ADDING_MULTIPLE_PERSONS_SUCCESS("Succeed to add multiple Persons in the database."),
	ADDING_MULTIPLE_PERSONS_ERROR("Error processing Person - add - multiple persons."),
	ADDING_MULTIPLE_MEDICATIONS_START("Started process to add multiple Medications in the database."),
	ADDING_MULTIPLE_MEDICATIONS_SUCCESS("Succeed to add multiple Medications in the database."),
	ADDING_MULTIPLE_MEDICATIONS_ERROR("Error processing Person - add - multiple Medications."),
	ADDING_MULTIPLE_FIRESTATIONS_START("Started process to add multiple Firestations in the database."),
	ADDING_MULTIPLE_FIRESTATIONS_SUCCESS("Succeed to add multiple Firestations in the database."),
	ADDING_MULTIPLE_FIRESTATIONS_ERROR("Error processing Person - add - multiple Firestations.");



	private final String value;

	EActionsProceedConstants(String value){
		this.value=value;
	}

	public String getValue(){
		return value;
	}

}
