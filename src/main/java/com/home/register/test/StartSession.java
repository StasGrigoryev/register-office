package com.home.register.test;

import com.home.register.domain.Person;
import com.home.register.domain.PersonMale;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StartSession {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Person person = new PersonMale();
        person.setFirstname("Leo");
        person.setLastname("Tolstoy");
        person.setPatronymic("Nikolas");
        person.setDateOfBirth(LocalDate.of(1821, Month.MAY,5));

        // save into database
//        Long id = (Long) session.save(person);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("The new object id: " + id);

        // get from database
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction();
        Person p = session.get(Person.class, 1L);
        session.close();

        System.out.println(p);

        // get all authors
        session = HibernateUtil.getSessionFactory().openSession();
        List<Person> people = session.createQuery("FROM ro_person", Person.class).list();
        people.forEach(System.out::println);
    }
}
