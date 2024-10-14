package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.JobOfferDTO;
import workforcemanger.workforce.entity.JobOffer;

public class JobOfferDTOMapper {

    public JobOfferDTOMapper() {}

    public JobOffer dtoToJobOffer(JobOfferDTO jobOfferDTO) {
        try {
            JobOffer jobOffer = new JobOffer();
            jobOffer.setId(jobOfferDTO.getId());
            jobOffer.setTitle(jobOfferDTO.getTitle());
            jobOffer.setDescription(jobOfferDTO.getDescription());
            jobOffer.setRequirements(jobOfferDTO.getRequirements());
            jobOffer.setDatePosted(jobOfferDTO.getDatePosted());
            jobOffer.setStatus(jobOfferDTO.getStatus());
            jobOffer.setValidityDate(jobOfferDTO.getValidityDate());
            jobOffer.setHrID(jobOfferDTO.getHrID());
            return jobOffer;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping JobOfferDTO to JobOffer", e);
        }
    }

    public JobOfferDTO jobOfferToDto(JobOffer jobOffer) {
        try {
            JobOfferDTO jobOfferDTO = new JobOfferDTO();
            jobOfferDTO.setId(jobOffer.getId());
            jobOfferDTO.setTitle(jobOffer.getTitle());
            jobOfferDTO.setDescription(jobOffer.getDescription());
            jobOfferDTO.setRequirements(jobOffer.getRequirements());
            jobOfferDTO.setDatePosted(jobOffer.getDatePosted());
            jobOfferDTO.setStatus(jobOffer.getStatus());
            jobOfferDTO.setValidityDate(jobOffer.getValidityDate());
            jobOfferDTO.setHrID(jobOffer.getHrID());
            return jobOfferDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping JobOffer to JobOfferDTO", e);
        }
    }
}
