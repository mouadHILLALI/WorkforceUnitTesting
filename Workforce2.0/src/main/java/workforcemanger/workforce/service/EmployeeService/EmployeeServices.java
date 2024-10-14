package workforcemanger.workforce.service.EmployeeService;

import workforcemanger.workforce.cache.Cache;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.entity.Employee;
import workforcemanger.workforce.helper.Validator;
import workforcemanger.workforce.mapper.EmployeeDTOMapper;
import workforcemanger.workforce.repository.Employee.EmployeeRepository;
import workforcemanger.workforce.repository.Employee.EmployeeRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class EmployeeServices {
    final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try {
//                Employee employee = null;
//                boolean flag = Validator.validateAllFields(employeeDTO.getUserName(),employeeDTO.getEmail(),employeeDTO.getPhoneNumber());
//                if (flag) {
//
//                }else {
//                    throw new IllegalArgumentException("Invalid employee data provided.");
//                }
            Employee employee = employeeRepository.create(EmployeeDTOMapper.DtoToEmployee(employeeDTO));
            return EmployeeDTOMapper.EmployeeToDto(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeDTO> getAllEmployees() {
        try {
            Cache cache = Cache.getInstance();
            List<EmployeeDTO> employeeDTOS = EmployeeDTOMapper.EmployeeListToEmployeeDTOList(employeeRepository.findAll());
            cache.populateCache(employeeDTOS);
            return employeeDTOS;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving employees", e);
        }
    }
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        try {
            Employee employee = employeeRepository.update(EmployeeDTOMapper.DtoToEmployee(employeeDTO));
            return EmployeeDTOMapper.EmployeeToDto(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean delete(int id){
        try {
            return employeeRepository.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public EmployeeDTO employeeLogin(String email, String password) {
        try {
            return EmployeeDTOMapper.EmployeeToDto(employeeRepository.login(email, password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
