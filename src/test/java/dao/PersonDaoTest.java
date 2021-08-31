package dao;

import com.home.register.dao.PersonDao;
import com.home.register.domain.Person;
import org.junit.Test;

import java.util.List;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();
        persons.forEach(p -> {
            System.out.println("==========================");
            System.out.println("Name: " + p.getFirstname());
            System.out.println("Class for gender: " + p.getClass().getName());
            System.out.println("Passports number: " + p.getPassports().size());
            System.out.println("Birth certificate: " + p.getBirthCertificate());
//            if (p instanceof PersonMale) {
//                System.out.println("Children number: " + ((PersonMale)p).getBirthCertificates().size() );
//                System.out.println("Marriages number: " + ((PersonMale)p).getMarriageCertificates().size() );
//            } else {
//                System.out.println("Children number: " + ((PersonFemale)p).getBirthCertificates().size() );
//                System.out.println("Marriages number: " + ((PersonFemale)p).getMarriageCertificates().size() );
//            }
        });
    }
}