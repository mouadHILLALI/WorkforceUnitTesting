package workforcemanger.workforce.repository.User;

import workforcemanger.workforce.configuration.JpaEntityManagerFactory;
import workforcemanger.workforce.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public <T> T create(T t) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
      try {
          if (t instanceof User){
              em.getTransaction().begin();
              em.persist(t);
              em.getTransaction().commit();
              return (T) t;
          }
      }catch (Exception e) {
          e.printStackTrace();
      }finally {
          if (em.isOpen()) {
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
        return null;
    }

    @Override
    public <T> T get(T t) {
        return null;
    }

    @Override
    public User Login(String email, String password) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        User foundUser = null;
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            foundUser = query.getSingleResult();
            if (foundUser != null && foundUser.getPassword().equals(password)) {
                em.getTransaction().commit();
                return foundUser;
            } else {
                em.getTransaction().rollback();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }


}
