package workforcemanger.workforce.controller;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.dto.UserDTO;
import workforcemanger.workforce.entity.JobOffer;
import workforcemanger.workforce.maas.MaasAuthetificationImpl;
import workforcemanger.workforce.service.EmployeeService.EmployeeServices;
import workforcemanger.workforce.service.GenericService.GenericServiceImpl;
import workforcemanger.workforce.service.UserService.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "user" , value = "/user")
public class UserServlet extends HttpServlet {
    MaasAuthetificationImpl maasAuthetification = new MaasAuthetificationImpl();
    final UserService userService = new UserService(maasAuthetification);
    final EmployeeServices employeeService = new EmployeeServices();
    final GenericServiceImpl genericService = new GenericServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action) {
        case "logout":
            logout(req, resp);
            break;
        case "getAll":
            getAllInfo(req, resp);
            break;
        default:
            break;
     }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String role = req.getParameter("userType");
        System.out.println(role);
        switch (action){
            case "register":
                create(req, resp);
                break;
            case "login":
               login(req, resp);
               break;
        }
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDTO user = new UserDTO();
            user.setUserName(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            user.setRole("candidate");
            user = userService.createUser(user);
            RequestDispatcher rd = req.getRequestDispatcher("/views/candidate.jsp");
            req.setAttribute("user", user);
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().invalidate();
            RequestDispatcher rd = req.getRequestDispatcher("/views/Auth/login.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String role = req.getParameter("userType");
            Object loggedInUser = null;

            if (role.equals("employee")) {
                EmployeeDTO employee = new EmployeeDTO();
                employee.setEmail(email);
                employee.setPassword(password);
                employee = userService.login(employee);
                reroute(req , resp , employee , "employee" );
            } else if (role.equals("other")) {
                UserDTO user = new UserDTO();
                user.setEmail(email);
                user.setPassword(password);
                user = userService.login(user);
                if (user!=null) {
                reroute(req , resp , user , user.getRole());
                }else{
                    RequestDispatcher rd = req.getRequestDispatcher("/views/Auth/login.jsp");
                    rd.forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred during login");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
    public void getAllInfo(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException {
        try {
            List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployees();
            req.setAttribute("employeeDTOS", employeeDTOS);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/adminEmployeManagement.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void reroute(HttpServletRequest req, HttpServletResponse response, Object obj, String role) {
        try {
            String target;
            switch (role) {
                case "employee":
                    target = "/views/employee/employee.jsp";
                    break;
                case "candidate":
                    target = "/views/candidate/candidate.jsp";
                    break;
                case "admin":
                    target = "/views/admin/admin.jsp";
                    break;
                case "hr":
                    target = "/views/hr/hr.jsp";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid role: " + role);
            }
            req.getSession().setAttribute("user", obj);
            if (role.equals("candidate")) {
                List<JobOffer> jobOffers = genericService.findAll(JobOffer.class);
                req.setAttribute("jobs", jobOffers);
            }
            RequestDispatcher rd = req.getRequestDispatcher(target);
            rd.forward(req, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
