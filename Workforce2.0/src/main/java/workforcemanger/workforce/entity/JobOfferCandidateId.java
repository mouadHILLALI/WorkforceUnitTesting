package workforcemanger.workforce.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class JobOfferCandidateId implements Serializable {
    private int jobOfferId;
    private int candidateId;

    public JobOfferCandidateId() {}

    public JobOfferCandidateId(int jobOfferId, int candidateId) {
        this.jobOfferId = jobOfferId;
        this.candidateId = candidateId;
    }

    public int getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(int jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public int hashCode() {
        return jobOfferId + candidateId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobOfferCandidateId)) return false;
        JobOfferCandidateId that = (JobOfferCandidateId) obj;
        return jobOfferId == that.jobOfferId && candidateId == that.candidateId;
    }
}
