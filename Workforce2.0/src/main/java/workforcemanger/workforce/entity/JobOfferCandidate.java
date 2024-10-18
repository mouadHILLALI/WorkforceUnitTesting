package workforcemanger.workforce.entity;

import javax.persistence.*;

@Entity
@Table(name = "job_offer_candidate")
public class JobOfferCandidate {

    @EmbeddedId
    private JobOfferCandidateId id;

    @ManyToOne
    @MapsId("jobOfferId")
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name = "candidate_id")
    private User candidate;
    public JobOfferCandidate(JobOffer jobOffer, User candidate) {
        this.id = new JobOfferCandidateId(jobOffer.getId(), candidate.getId());
        this.jobOffer = jobOffer;
        this.candidate = candidate;
    }

    public JobOfferCandidate() {
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }
    public User getCandidate() {
        return candidate;
    }
    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }
    public JobOffer getJobOffer() {
        return jobOffer;
    }
    public JobOfferCandidateId getId() {
        return id;
    }
    public void setId(JobOfferCandidateId id) {
        this.id = id;
    }
}
