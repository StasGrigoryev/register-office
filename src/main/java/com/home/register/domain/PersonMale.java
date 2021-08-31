package com.home.register.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
            mappedBy = "husband")
    private List<MarriageCertificate> marriageCertificates;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
            mappedBy = "father")
    private List<BirthCertificate> birthCertificates;
}
