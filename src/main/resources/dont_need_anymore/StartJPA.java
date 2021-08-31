package dont_need_anymore;


import com.home.register.domain.Person;
import com.home.register.domain.PersonMale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StartJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new PersonMale();
        p.setFirstname("Herbert");
        p.setLastname("Wells");
        p.setPatronymic("Percival");
        p.setDateOfBirth(LocalDate.of(1952, Month.OCTOBER,2));

        em.persist(p);

        System.out.println(p);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List people = em.createQuery("FROM Person").getResultList();
        people.forEach(System.out::println);

        em.close();


    }


}
