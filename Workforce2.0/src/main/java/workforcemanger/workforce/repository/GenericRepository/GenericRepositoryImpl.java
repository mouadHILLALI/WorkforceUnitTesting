package workforcemanger.workforce.repository.GenericRepository;

import workforcemanger.workforce.configuration.JpaEntityManagerFactory;
import workforcemanger.workforce.repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class GenericRepositoryImpl implements Repository {
    private JpaEntityManagerFactory emf;
    public GenericRepositoryImpl(JpaEntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public <T> T create(T t) {
            EntityManager em = emf.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            em.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()){
                em.getTransaction().rollback();
                em.close();
            }
        }
        return t;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public <T> T update(T t) {
        EntityManager em = emf.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            em.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()){
                em.getTransaction().rollback();
                em.close();
            }
        }
        return t;
    }

    @Override
    public <T> T get(Class<T> clazz, int id) {
        EntityManager em = emf.getEntityManager();
        T entity = null;
        try {
            em.getTransaction().begin();
            entity = em.find(clazz, id);
            em.getTransaction().commit();
            em.close();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return entity;
    }

    public <T> List<T> findAll(Class<T> clazz, int hrId){
        EntityManager em = emf.getEntityManager();
        List<T> resultList = null;
        try {
            em.getTransaction().begin();
            resultList = em.createQuery("SELECT u FROM " + clazz.getSimpleName() + " u WHERE u.hrID = :hrid", clazz)
                    .setParameter("hrid", hrId)
                    .getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return resultList;
    }
    public <T> List<T> findAll(Class<T> clazz){
        EntityManager em = emf.getEntityManager();
        List<T> resultList = null;
        try {
            em.getTransaction().begin();
            resultList = em.createQuery("SELECT u FROM " + clazz.getSimpleName() + " u", clazz).getResultList();
            em.getTransaction().commit();
            em.close();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
            }
        }
        return resultList;
    }

}
