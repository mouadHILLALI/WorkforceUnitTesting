package workforcemanger.workforce.controller;

import workforcemanger.workforce.dto.UserDTO;
import workforcemanger.workforce.entity.JobOffer;
import workforcemanger.workforce.entity.JobOfferCandidate;
import workforcemanger.workforce.entity.User;
import workforcemanger.workforce.service.GenericService.GenericServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "jobOffer" , value = "/offer")
public class JobOfferServlet extends HttpServlet {
    final GenericServiceImpl genericService = new GenericServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action){
        case "getAll":
            getAllJobOffers(req, resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action) {
        case "create":
            createJobOffer(req, resp);
            break;
        case "apply":
            applyJobOffer(req, resp);
            break;
    }
    }
    public void createJobOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("Title");
            String description = request.getParameter("Description");
            String Requirements = request.getParameter("Requirements");
            int salary = Integer.parseInt(request.getParameter("salary"));
            LocalDate validity = LocalDate.parse(request.getParameter("validityDate"));
            int hrId = Integer.parseInt(request.getParameter("id"));
            String status = "valid";
            JobOffer jobOffer = new JobOffer(title , description , Requirements , LocalDate.now() , salary ,status ,validity , hrId );
            Object obj = genericService.create(jobOffer);
            if (obj != null) {
                request.setAttribute("message", "Job Offer created");
            }else{
                request.setAttribute("message", "Job Offer was not created");
            }
            response.setContentType("text/html");
            RequestDispatcher view = request.getRequestDispatcher("/views/hr/hr.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getAllJobOffers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Class<JobOffer> JobOffer = JobOffer.class;
                List<JobOffer> jobOffers = genericService.findAllById(JobOffer , id);
                request.setAttribute("offers", jobOffers);
                UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                request.setAttribute("user", user);
                RequestDispatcher view = request.getRequestDispatcher("/views/hr/jobOffers.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void applyJobOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int jobOfferId = Integer.parseInt(request.getParameter("jobId"));
            System.out.println("user id" + userId);
            System.out.println("jobOfferId" + jobOfferId);

            User user = genericService.findById(User.class, userId);
            JobOffer jobOffer = genericService.findById(JobOffer.class, jobOfferId);
            System.out.println(user.toString());
            System.out.println(jobOffer.toString());
            JobOfferCandidate jobOfferCandidate = new JobOfferCandidate(jobOffer, user);
            genericService.create(jobOfferCandidate);
            request.setAttribute("message", "Job Offer applied successfully");
            RequestDispatcher view = request.getRequestDispatcher("/views/candidate/candidate.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to apply for job offer");
            RequestDispatcher view = request.getRequestDispatcher("/views/error.jsp");
            view.forward(request, response);
        }
    }

}
