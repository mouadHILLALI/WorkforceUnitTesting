package workforcemanger.workforce.entity;

import workforcemanger.workforce.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_offers")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String requirements;
    private LocalDate datePosted;
    private int salary;
    private String status;
    private LocalDate validityDate;
    @Column(name = "hrid")
    private int hrID;
    @OneToMany(mappedBy = "jobOffer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobOfferCandidate> candidates = new ArrayList<>();
    public JobOffer() {}
    public JobOffer(String title,String description , String requirements , LocalDate datePosted, int salary, String status, LocalDate validityDate, int hrID) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.datePosted = datePosted;
        this.salary = salary;
        this.status = status;
        this.validityDate = validityDate;
        this.hrID = hrID;
    }

    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRequirements() {
        return requirements;
    }
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    public LocalDate getDatePosted() {
        return datePosted;
    }
    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getValidityDate() {
        return validityDate;
    }
    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }
    public int getHrID() {
        return hrID;
    }
    public void setHrID(int hrID) {
        this.hrID = hrID;
    }
}
