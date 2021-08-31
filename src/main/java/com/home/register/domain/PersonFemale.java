package com.home.register.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
            mappedBy = "wife")
    private List<MarriageCertificate> marriageCertificates;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
            mappedBy = "mother")
    private List<BirthCertificate> birthCertificates;
}
