package workforcemanger.workforce.repository.Employee;

import workforcemanger.workforce.configuration.JpaEntityManagerFactory;
import workforcemanger.workforce.entity.Employee;
import workforcemanger.workforce.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public <T> T create(T t) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        if (t instanceof Employee) {
            try {
                em.getTransaction().begin();
                em.persist(t);
                em.getTransaction().commit();
                return t;
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public boolean delete(int id) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
      try {
          em.getTransaction().begin();
          Employee employee = em.find(Employee.class, id);
          em.remove(employee);
          em.getTransaction().commit();
          return true;
      }catch (Exception e) {
          if (em.getTransaction().isActive()) {
              em.getTransaction().rollback();
          }
          e.printStackTrace();
      }
      return false;
    }

    @Override
    public <T> T update(T t) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        if (t instanceof Employee) {
            try {
                em.getTransaction().begin();
                Employee employee = em.find(Employee.class, ((Employee) t).getId());
                if (employee != null) {
                    em.merge(t);
                    em.getTransaction().commit();
                    return t;
                } else {
                    throw new RuntimeException("Employee not found for ID: " + ((Employee) t).getId());
                }
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw new RuntimeException("Error updating employee", e);
            }
        }
        throw new IllegalArgumentException("Unsupported entity type: " + t.getClass().getSimpleName());
    }

    @Override
    public <T> T get(T t) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        List<Employee> employees = new ArrayList<>();
        try {
            em.getTransaction().begin();
            employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return employees;
    }

    @Override
    public Employee login(String email, String password) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        Employee foundEmployee = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Employee> query = em.createQuery("SELECT u FROM Employee u WHERE u.email = :email", Employee.class);
            query.setParameter("email", email);
            foundEmployee = query.getSingleResult();
            if (foundEmployee != null && foundEmployee.getPassword().equals(password)) {
                em.getTransaction().commit();
                return foundEmployee;
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
