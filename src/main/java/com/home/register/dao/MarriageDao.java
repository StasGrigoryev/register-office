package com.home.register.dao;

import com.home.register.domain.MarriageCertificate;
import com.home.register.view.MarriageRequest;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Setter
@Slf4j
@Component
public class MarriageDao {
    private EntityManager entityManager;
    @Value("${test.value}")
    private String testField;

    public MarriageDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = emf.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        log.info("findMarriageCertificate called. Test field: {}", testField);
//        Query query = entityManager.createNamedQuery("MarriageCertificate.findMarriageCertificate");
//        query.setParameter("wifeId", 1L);
//        query.setParameter("husbandId", 2L);
//        List<MarriageCertificate> results = query.getResultList();
        return null;
    }
}
