package workforcemanger.workforce.service.UserService;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.dto.UserDTO;
import workforcemanger.workforce.entity.Employee;
import workforcemanger.workforce.entity.User;
import workforcemanger.workforce.helper.Validator;
import workforcemanger.workforce.maas.MaasAuthetificationImpl;
import workforcemanger.workforce.mapper.EmployeeDTOMapper;
import workforcemanger.workforce.mapper.UserDTOMapper;
import workforcemanger.workforce.repository.User.UserRepositoryImpl;

import java.util.Optional;

public class UserService {
    final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    final UserDTOMapper userDTOMapper = new UserDTOMapper();
    private MaasAuthetificationImpl maasAuthetification ;
    public UserService(MaasAuthetificationImpl maasAuthetification) {
        this.maasAuthetification = maasAuthetification;
    }
    public UserDTO createUser(UserDTO userDTO) {
        try {
            User user = userDTOMapper.DtoToUser(userDTO);
            return userDTOMapper.UserToDto(userRepository.create(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public UserDTO login(UserDTO userDTO) {
        try {
            if (Validator.validateEmail(userDTO.getEmail())
                    && userDTO.getPassword() != null
                    && !userDTO.getPassword().isEmpty()) {
                User user = maasAuthetification.login(userDTOMapper.DtoToUser(userDTO));
                if (user != null) {
                    return userDTOMapper.UserToDto(user);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during user login", e);
        }
        return userDTO;
    }
    public EmployeeDTO login(EmployeeDTO employeeDTO) {
        try {
            if (Validator.validateEmail(employeeDTO.getEmail())
                    && employeeDTO.getPassword() != null
                    && !employeeDTO.getPassword().isEmpty()) {
                Employee employee = maasAuthetification.login(EmployeeDTOMapper.DtoToEmployee(employeeDTO));
                if (employee != null) {
                    return EmployeeDTOMapper.EmployeeToDto(employee);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during employee login", e);
        }
        return employeeDTO;
    }
}
