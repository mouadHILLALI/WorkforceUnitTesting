package workforcemanger.workforce.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManagerFactory {
    private static EntityManagerFactory emf;

    public JpaEntityManagerFactory() {}

    public static EntityManager getEntityManager() {
        if (emf == null) {
            synchronized (JpaEntityManagerFactory.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory("workforce-unit");
                }
            }
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
