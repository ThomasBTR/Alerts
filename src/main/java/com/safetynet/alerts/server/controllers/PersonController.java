package com.safetynet.alerts.server.controllers;

import com.safetynet.alerts.server.services.PersonsPostService;
import io.swagger.api.AddPersonsApi;
import io.swagger.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/person")
public class PersonController implements AddPersonsApi {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	PersonsPostService personsPostService;

	@Override
	public ResponseEntity<Void> addPersonsToDatabase(Persons body) {
		return AddPersonsApi.super.addPersonsToDatabase(body);
	}
}
