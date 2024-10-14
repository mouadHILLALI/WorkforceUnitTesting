package workforcemanger.workforce.repository.Employee;

import workforcemanger.workforce.entity.Employee;
import workforcemanger.workforce.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository {
    public List<Employee> findAll();
    public Employee login(String email, String password);
}
