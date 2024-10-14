package workforcemanger.workforce.entity;

import workforcemanger.workforce.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private LocalDate validityDate;
    private int hrID;

    public JobOffer() {}


    public int getId() {
        return id;
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
    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
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
