CREATE SCHEMA safetynet;
CREATE TABLE safetynet.cities (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cityName VARCHAR(255),
    zip VARCHAR(10));
CREATE TABLE safetynet.addresses (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    address VARCHAR(255),
    station VARCHAR(255));
CREATE TABLE safetynet.medecines (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    medecineName VARCHAR(255));
CREATE TABLE safetynet.allergenes (
		id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        alergeneName VARCHAR(255));
CREATE TABLE safetynet.persons (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  birthdate DATE,
  email VARCHAR(255),
  phone VARCHAR(255),
  cityName VARCHAR(255) REFERENCES safetynet.cities(cityName),
  address VARCHAR(255) REFERENCES safetynet.addresses (address));
CREATE TABLE safetynet.medications (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_person INT REFERENCES safetynet.persons (id),
    id_medecine INT REFERENCES safetynet.medecines (id),
    dosage VARCHAR(255));
CREATE TABLE safetynet.allergies (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_person INT REFERENCES safetynet.persons (id),
	id_allergene INT REFERENCES safetynet.allergenes (id));
	
  