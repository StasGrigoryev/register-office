DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex smallint not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    patronymic varchar(100),
    date_birth date not null,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id integer not null,
    series varchar(10) not null,
    number varchar(10) not null,
    issue_date date not null,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate (
    birth_certificate_id SERIAL,
    certificate_number varchar(20) not null,
    issue_date date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);


CREATE TABLE ro_marriage_certificate (
    marriage_certificate_id SERIAL,
    certificate_number varchar(20) not null,
    issue_date date not null,
    husband_id integer not null,
    wife_id integer not null,
    active boolean DEFAULT false,
    end_date date,
    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);


INSERT INTO ro_person (sex, first_name, last_name, patronymic, birth_date)
VALUES (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
(2, 'Олег', 'Васильев', 'Петрович', '1997-10-16'),
(2, 'Николай', 'Васильев', 'Олегович', '2018-10-21');

insert into ro_passport(person_id, series, number, issue_date, issue_department)
values(1, '1234', '123456', '2018-04-10', 'Passport Department');

INSERT INTO ro_birth_certificate (certificate_number, issue_date, person_id,
mother_id, father_id) VALUES ('123 Birth', '2018-1-01', 3, 1, 2);

insert into ro_marriage_certificate(
	certificate_number, issue_date, husband_id, wife_id, active)
	values(12345, current_date, 1, 2, true)