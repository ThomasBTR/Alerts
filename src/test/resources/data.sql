create schema safetynet;

create table allergenes
(
    id        integer not null auto_increment,
    allergene varchar(255),
    primary key (id)
);
create table allergies
(
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    allergies_id integer      not null
);
create table medication_entity
(
    id                       integer not null auto_increment,
    dosage                   integer not null,
    medicine_entity_id       integer,
    person_entity_first_name varchar(255),
    person_entity_last_name  varchar(255),
    primary key (id)
);
create table medicines
(
    id            integer not null auto_increment,
    medecine_name varchar(255),
    primary key (id)
);
create table persons
(
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    address    varchar(255),
    city       varchar(255),
    zip        varchar(255),
    email      varchar(255),
    phone      varchar(255),
    birthdate  date,
    station    integer      not null,
    primary key (first_name, last_name)
);
alter table allergies
    add constraint FKf7ic7ic8rqos08obl18nmeghd
        foreign key (allergies_id)
            references allergenes (id);
alter table allergies
    add constraint FKluswmssetwv3mccgpp9q4pl2o
        foreign key (first_name, last_name)
            references persons (first_name, last_name);
alter table medication_entity
    add constraint FKpdtd3k70atqvvi4mmfoflo36g
        foreign key (medicine_entity_id)
            references medicines (id);
alter table medication_entity
    add constraint FKh1gwf3xb2p9sp457gm8oycrsr
        foreign key (person_entity_first_name, person_entity_last_name)
            references persons (first_name, last_name);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('John', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com', '1984-03-06', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Jacob', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6513', 'drk@email.com', '1989-03-06', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Tenley', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'tenz@email.com', '2012-02-18', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Roger', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com', '2017-09-06', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Felicia', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6544', 'jaboyd@email.com', '1986-01-08', 0);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Jonanathan', 'Marrack', '29 15th St', 'Culver', 97451, '841-874-6513', 'drk@email.com', '1989-01-03', 2);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Tessa', 'Carman', '834 Binoc Ave', 'Culver', 97451, '841-874-6512', 'tenz@email.com', '2012-02-18', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Peter', 'Duncan', '644 Gershwin Cir', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com', '2000-09-06', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Foster', 'Shepard', '748 Townings Dr', 'Culver', 97451, '841-874-6544', 'jaboyd@email.com', '1980-01-08', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Tony', 'Cooper', '112 Steppes Pl', 'Culver', 97451, '841-874-6874', 'tcoop@ymail.com', '1994-03-06', 4);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Lily', 'Cooper', '489 Manchester St', 'Culver', 97451, '841-874-9845', 'lily@email.com', '1994-03-06', 4);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Sophia', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7878', 'soph@email.com', '1988-03-06', 2);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Warren', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7512', 'ward@email.com', '1985-03-06', 2);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Zach', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7512', 'zarc@email.com', '2017-03-06', 2);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Reginold', 'Walker', '908 73rd St', 'Culver', 97451, '841-874-8547', 'reg@email.com', '1979-08-30', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Jamie', 'Peters', '908 73rd St', 'Culver', 97451, '841-874-7462', 'jpeter@email.com', '1982-03-06', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Ron', 'Peters', '112 Steppes Pl', 'Culver', 97451, '841-874-8888', 'jpeter@email.com', '1965-03-15', 4);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Allison', 'Boyd', '112 Steppes Pl', 'Culver', 97451, '841-874-9888', 'aly@imail.com', '1975-12-06', 4);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Brian', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'bstel@email.com', '1970-1-1', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Shawna', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'ssanw@email.com', '1980-07-08', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Kendrik', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'bstel@email.com', '2014-03-06', 1);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Clive', 'Ferguson', '748 Townings Dr', 'Culver', 97451, '841-874-6741', 'clivfd@ymail.com', '1994-03-06', 3);
INSERT INTO persons(first_name, last_name, address, city, zip, phone, email, birthdate, station)
VALUES ('Eric', 'Cadigan', '951 LoneTree Rd', 'Culver', 97451, '841-874-7458', 'gramps@email.com', '1945-08-06', 2)