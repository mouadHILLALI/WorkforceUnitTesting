package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTOMapper {

    public EmployeeDTOMapper() {}

    public static Employee DtoToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = null ;
        try {
            return employee = new Employee(
                    employeeDTO.getId(),
                employeeDTO.getUserName() , employeeDTO.getEmail() , "employee" , employeeDTO.getPhoneNumber() , employeeDTO.getDateOfBirth(),
                employeeDTO.getAddress(), employeeDTO.getPosition(), employeeDTO.getHireDate(), employeeDTO.getSalary(), employeeDTO.getChildrenCount(),
                    employeeDTO.getSocialSecurityNumber() , employeeDTO.getPassword()
            );
        } catch (Exception e) {
            System.out.println(employee.toString());
            throw new RuntimeException("Error mapping EmployeeDTO to Employee", e);
        }
    }
    public static EmployeeDTO EmployeeToDto(Employee employee) {
        EmployeeDTO employeeDTO = null;
        try {
             employeeDTO = new EmployeeDTO(
                    employee.getId() , employee.getUserName() , employee.getEmail(),
                    employee.getAddress() , employee.getPosition() , employee.getHireDate(),
                    employee.getSalary() ,employee.getChildrenCount(),employee.getSocialSecurityNumber(),
                    employee.getPhone(),employee.getDateOfBirth() , employee.getPassword()
            );
            return employeeDTO;
        } catch (Exception e) {
            System.out.println(employeeDTO.toString());
            throw new RuntimeException("Error mapping Employee to EmployeeDTO", e);
        }
    }
    public static List<EmployeeDTO> EmployeeListToEmployeeDTOList(List<Employee> employees) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = EmployeeToDto(employee);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
}
