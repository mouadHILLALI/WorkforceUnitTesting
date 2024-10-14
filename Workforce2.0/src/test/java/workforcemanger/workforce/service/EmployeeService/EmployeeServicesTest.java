package workforcemanger.workforce.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import workforcemanger.workforce.dto.EmployeeDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeServicesTest {

    private EmployeeServices employeeServices;
    Mockito mockito = new Mockito();
    @BeforeEach
    void setUp() {
        employeeServices = mockito.mock(EmployeeServices.class);
    }
    @Test
    void updateEmployee() {
        EmployeeDTO employee = new EmployeeDTO(1, "John Doe", "johndoe@example.com",
                "1234 Elm Street", "Developer",
                LocalDate.of(2020, 1, 1), 4000.0,
                2, "123-45-6789", "1234567890",
                LocalDate.of(1990, 1, 1 ), "ghjhgfd");
        EmployeeDTO updatedEmployee = employeeServices.update(employee);
        assertNotNull(updatedEmployee);
        assertEquals("John Doe" , updatedEmployee.getUserName());
        assertEquals(1 , updatedEmployee.getId());
    }
}