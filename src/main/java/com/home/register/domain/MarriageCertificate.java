package com.home.register.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Table(name = "ro_marriage_certificate")
@Entity
//@NamedQueries({
//        @NamedQuery(name = "MarriageCertificate.findMarriageCertificate",
//                query = "   select c from MarriageCertificate mc " +
//                        "   join fetch mc.husband h" +
//                        "   join fetch mc.wife w" +
//                        "   where mc.husband = :husbandId and mc.wife = :wifeId")
//})
public class MarriageCertificate implements Serializable {
    @Column(name = "marriage_certificate_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marriageCertificateId;
    @Column(name = "certificate_number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;
    @Column(name = "active")
    private boolean active;
    @Column(name = "end_date")
    private LocalDate endDate;
}
