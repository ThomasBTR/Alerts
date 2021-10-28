create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)
create table allergenes (id integer not null auto_increment, allergene varchar(255), primary key (id)) engine=InnoDB
create table allergies (person_id integer not null, allergies_id integer not null) engine=InnoDB
create table medication_entity (id integer not null auto_increment, dosage integer not null, medicine_entity_id integer, person_entity_id integer, primary key (id)) engine=InnoDB
create table medicines (id integer not null auto_increment, medecine_name varchar(255), primary key (id)) engine=InnoDB
create table persons (id integer not null auto_increment, address varchar(255), city varchar(255), station integer not null, zip varchar(255), birthdate date, email varchar(255), first_name varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
alter table allergies add constraint FKf7ic7ic8rqos08obl18nmeghd foreign key (allergies_id) references allergenes (id)
alter table allergies add constraint FKngwbqn6ypfd8v9yyld37t88kn foreign key (person_id) references persons (id)
alter table medication_entity add constraint FKpdtd3k70atqvvi4mmfoflo36g foreign key (medicine_entity_id) references medicines (id)
alter table medication_entity add constraint FKoa75us408hhj8fkqladnmm81w foreign key (person_entity_id) references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)

    create table allergenes (
       id integer not null auto_increment,
        allergene varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table allergies (
       person_id integer not null,
        allergies_id integer not null
    ) engine=InnoDB

    create table medication_entity (
       id integer not null auto_increment,
        dosage integer not null,
        medicine_entity_id integer,
        person_entity_id integer,
        primary key (id)
    ) engine=InnoDB

    create table medicines (
       id integer not null auto_increment,
        medecine_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table persons (
       id integer not null auto_increment,
        address varchar(255),
        city varchar(255),
        station integer not null,
        zip varchar(255),
        birthdate date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table allergies 
       add constraint FKf7ic7ic8rqos08obl18nmeghd 
       foreign key (allergies_id) 
       references allergenes (id)

    alter table allergies 
       add constraint FKngwbqn6ypfd8v9yyld37t88kn 
       foreign key (person_id) 
       references persons (id)

    alter table medication_entity 
       add constraint FKpdtd3k70atqvvi4mmfoflo36g 
       foreign key (medicine_entity_id) 
       references medicines (id)

    alter table medication_entity 
       add constraint FKoa75us408hhj8fkqladnmm81w 
       foreign key (person_entity_id) 
       references persons (id)
