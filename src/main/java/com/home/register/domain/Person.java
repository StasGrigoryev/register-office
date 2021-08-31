package com.home.register.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Table(name = "ro_person")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sex", discriminatorType = DiscriminatorType.INTEGER)

@NamedQueries({
        @NamedQuery(name = "Person.findPersons",
        query = "select p from Person p " +
                "left join fetch p.passports ps " +
                "left join fetch p.birthCertificate bc " +
                "where p.personId = :personId")
})

public abstract class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "patronymic")
    private String patronymic;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
                mappedBy = "person")
    private BirthCertificate birthCertificate;
    @Column(name = "birth_date")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "person", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Passport> passports;

}
