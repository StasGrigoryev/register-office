package com.home.register.dao;

import com.home.register.domain.Person;

import javax.persistence.*;
import java.util.List;

@PersistenceContext
public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        //temp em initialization
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        entityManager = emf.createEntityManager();
    }

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 1L);
        return query.getResultList();
    }
}
