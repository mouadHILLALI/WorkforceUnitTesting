package workforcemanger.workforce.controller;

import workforcemanger.workforce.cache.Cache;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.service.EmployeeService.EmployeeServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "employee" , value = "/employee")
public class EmployeeServlet extends HttpServlet {
    final EmployeeServices employeeServices = new EmployeeServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "update":
                getEmployee(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action) {
        case "create":
            create(req,resp);
            break;
        case "update":
            update(req,resp);
            break;
    }
    }
    public void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setUserName(req.getParameter("name"));
            employeeDTO.setEmail(req.getParameter("email"));
            employeeDTO.setPhoneNumber(req.getParameter("phone"));
            employeeDTO.setAddress(req.getParameter("address"));
            employeeDTO.setSalary(Double.valueOf(req.getParameter("salary")));
            employeeDTO.setChildrenCount(Integer.valueOf(req.getParameter("childrenCount")));
            employeeDTO.setDateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")));
            employeeDTO.setHireDate(LocalDate.parse(req.getParameter("dateOfHiring")));
            employeeDTO.setPosition(req.getParameter("position"));
            employeeDTO.setSocialSecurityNumber(req.getParameter("socialSecurityNumber"));
            employeeDTO = employeeServices.createEmployee(employeeDTO);
            req.getSession().setAttribute("employee", employeeDTO);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin.jsp");
            res.setContentType("text/html");
            dispatcher.forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            EmployeeDTO employeeDTO = Cache.getFromCache(id);
            resp.setContentType("text/html");
            req.setAttribute("employee", employeeDTO);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/updateEmployee.jsp");
            dispatcher.forward(req, resp);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String userName = req.getParameter("userName");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            LocalDate hireDate = LocalDate.parse(req.getParameter("hireDate"));
            Double salary = Double.parseDouble(req.getParameter("salary"));
            int childrenCount = Integer.parseInt(req.getParameter("childrenCount"));
            String socialSecurityNumber = req.getParameter("socialSecurityNumber");
            String phoneNumber = req.getParameter("phone");
            String password = req.getParameter("password");
            LocalDate dateOfBirth = LocalDate.parse(req.getParameter("birthDate"));
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    id, userName, email, address, position,
                    hireDate, salary, childrenCount, socialSecurityNumber, phoneNumber, dateOfBirth , password
            );
            employeeDTO = employeeServices.update(employeeDTO);
            req.getSession().setAttribute("employee", employeeDTO);
            RequestDispatcher rq = req.getRequestDispatcher("/views/admin/adminEmployeManagement.jsp");
            rq.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean deleted = employeeServices.delete(id);
            if (deleted) {
                req.getSession().setAttribute("message", "Employee deleted successfully");
            }else {
                req.getSession().setAttribute("message", "Employee not deleted successfully");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/adminEmployeManagement.jsp");
            dispatcher.forward(req, resp);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
