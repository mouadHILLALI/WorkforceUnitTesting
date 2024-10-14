package workforcemanger.workforce.dto;

import workforcemanger.workforce.enums.StatusEnum;

import java.time.LocalDate;

public class JobOfferDTO {
    private int id;
    private String title;
    private String description;
    private String requirements;
    private LocalDate datePosted;
    private StatusEnum status;
    private LocalDate validityDate;
    private int hrID;

    public JobOfferDTO() {}


    public JobOfferDTO(int id, String title, String description, String requirements, LocalDate datePosted, StatusEnum status, LocalDate validityDate , int hrID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.datePosted = datePosted;
        this.status = status;
        this.validityDate = validityDate;
        this.hrID = hrID;
    }

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


    @Override
    public String toString() {
        return "JobOfferDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", datePosted=" + datePosted +
                ", status=" + status +
                ", validityDate=" + validityDate +
                '}';
    }
}
