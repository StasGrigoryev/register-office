package dont_need_anymore;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
