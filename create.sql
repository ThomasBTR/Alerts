    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies
       add constraint FKf7ic7ic8rqos08obl18nmeghd
       foreign key (allergies_id)
       references allergenes (id)

    alter table allergies
       add constraint FKluswmssetwv3mccgpp9q4pl2o
       foreign key (first_name, last_name)
       references persons (first_name, last_name)

    alter table medication_entity
       add constraint FKpdtd3k70atqvvi4mmfoflo36g
       foreign key (medicine_entity_id)
       references medicines (id)

    alter table medication_entity
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr
       foreign key (person_entity_first_name, person_entity_last_name)
       references persons (first_name, last_name)
    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_first_name varchar(255),
        person_entity_last_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       first_name varchar(255) not null,
        last_name varchar(255) not null,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        phone varchar(255),
        primary key (first_name, last_name)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKluswmssetwv3mccgpp9q4pl2o 
       foreign key (first_name, last_name) 
       references persons (first_name, last_name)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKh1gwf3xb2p9sp457gm8oycrsr 
       foreign key (person_entity_first_name, person_entity_last_name) 
       references persons (first_name, last_name)
