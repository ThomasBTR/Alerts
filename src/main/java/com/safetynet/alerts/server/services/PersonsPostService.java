package com.safetynet.alerts.server.services;

import com.safetynet.alerts.database.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsPostService {

	@Autowired
	PersonRepository personRepository;



}
