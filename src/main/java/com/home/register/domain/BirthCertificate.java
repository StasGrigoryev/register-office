package com.home.register.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Table(name = "ro_birth_certificate")
@Entity
public class BirthCertificate implements Serializable {
    @Column(name = "birth_certificate_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BirthCertificateId;
    @Column(name = "certificate_number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id")
    private PersonMale father;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "mother_id")
    private PersonFemale mother;
}
