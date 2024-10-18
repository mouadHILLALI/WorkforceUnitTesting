package workforcemanger.workforce.repository.LeaveRequest;

import workforcemanger.workforce.configuration.JpaEntityManagerFactory;
import workforcemanger.workforce.entity.LeaveRequest;

import javax.persistence.EntityManager;

public class LeaveRequestRepositoryImpl  implements LeaveRequestRepoistory{
    @Override
    public <T> T create(T t) {
            EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            if (t instanceof LeaveRequest) {
                em.getTransaction().begin();
                em.persist(t);
                em.getTransaction().commit();
                return (T) t;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()){
                em.getTransaction().rollback();
                em.close();
            }
        }finally {
            em.close();
        }
        return t;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public <T> T update(T t) {
        return null;
    }

    @Override
    public <T> T get(Class<T> clazz, int id) {
        return null;
    }
}
