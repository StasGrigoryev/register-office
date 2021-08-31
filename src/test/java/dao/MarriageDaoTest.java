package dao;

import com.home.register.dao.MarriageDao;
import com.home.register.domain.MarriageCertificate;
import org.junit.Test;
import com.home.register.view.MarriageRequest;

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        MarriageDao dao = new MarriageDao();
        MarriageCertificate cert = dao.findMarriageCertificate(new MarriageRequest());
        System.out.println("cert number: " + cert.getNumber());
        System.out.println("cert husband: " + cert.getHusband().getFirstname() + " " +
                cert.getHusband().getLastname());
        System.out.println("cert wife: " + cert.getWife().getFirstname() + " " +
                cert.getWife().getLastname());
    }
}
