package workforcemanger.workforce.controller;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.dto.LeaveRequestDTO;
import workforcemanger.workforce.service.LeaveRequestService.LeaveRequestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "leave", value = "/leave")
public class LeaveRequestServlet extends HttpServlet {
    final LeaveRequestService leaveRequestService = new LeaveRequestService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action){
        case "leave":
        applyForLeave(req, resp);
        break;
        }
    }
    public void applyForLeave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String leaveType = req.getParameter("leaveType");
            LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
            String leaveReason = req.getParameter("reason");
            String supportingDocs = req.getParameter("file");
            Object obj = req.getSession().getAttribute("employee");
            EmployeeDTO employee = (EmployeeDTO) obj;
            LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(startDate,endDate , leaveReason , "pending" , supportingDocs , 40 ,employee.getId(),leaveType);
            LeaveRequestDTO leaveRequest = leaveRequestService.createLeaveRequest(leaveRequestDTO);
            if (leaveRequest != null) {
                req.getSession().setAttribute("message", "leave request send successfully");
            }else{
                req.getSession().setAttribute("message", "leave request send unsuccessfully");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/employee/employee.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
