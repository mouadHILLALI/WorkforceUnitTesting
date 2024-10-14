package workforcemanger.workforce.repository.JobOffer;

import workforcemanger.workforce.configuration.JpaEntityManagerFactory;
import workforcemanger.workforce.entity.JobOffer;

import javax.persistence.EntityManager;

public class JobOfferRepositoryImpl implements JobOfferRepository {
    final EntityManager em = JpaEntityManagerFactory.getEntityManager();
    @Override
    public <T> T create(T t) {
        if (t instanceof JobOffer) {
            try {
                em.getTransaction().begin();
                em.persist(t);
                em.getTransaction().commit();
                return t;
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw new RuntimeException("Error persisting JobOffer", e);
            }
        }
        throw new IllegalArgumentException("Unsupported entity type: " + t.getClass().getSimpleName());
    }

    @Override
    public <T> T update(T t) {
        if (t instanceof JobOffer) {
            try {
                em.getTransaction().begin();
                T mergedEntity = em.merge(t);
                em.getTransaction().commit();
                return mergedEntity;
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw new RuntimeException("Error updating JobOffer", e);
            }
        }
        throw new IllegalArgumentException("Unsupported entity type: " + t.getClass().getSimpleName());
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public <T> T get(T t) {
        return null;
    }
}
