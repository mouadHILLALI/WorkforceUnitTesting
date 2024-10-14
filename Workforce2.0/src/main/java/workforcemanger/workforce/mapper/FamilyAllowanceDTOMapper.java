package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.FamilyAllowanceDTO;
import workforcemanger.workforce.entity.FamilyAllowance;

public class FamilyAllowanceDTOMapper {

    public FamilyAllowanceDTOMapper() {}

    public FamilyAllowance dtoToFamilyAllowance(FamilyAllowanceDTO familyAllowanceDTO) {
        try {
            FamilyAllowance familyAllowance = new FamilyAllowance();
            familyAllowance.setFamilyId(familyAllowanceDTO.getFamilyId());
            familyAllowance.setChildrenCount(familyAllowanceDTO.getChildrenCount());
            familyAllowance.setAllowanceAmount(familyAllowanceDTO.getAllowanceAmount());
            familyAllowance.setSalaryAmount(familyAllowanceDTO.getSalaryAmount());
            familyAllowance.setDateCalculated(familyAllowanceDTO.getDateCalculated());
            return familyAllowance;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping FamilyAllowanceDTO to FamilyAllowance", e);
        }
    }

    public FamilyAllowanceDTO familyAllowanceToDto(FamilyAllowance familyAllowance) {
        try {
            FamilyAllowanceDTO familyAllowanceDTO = new FamilyAllowanceDTO();
            familyAllowanceDTO.setFamilyId(familyAllowance.getFamilyId());
            familyAllowanceDTO.setChildrenCount(familyAllowance.getChildrenCount());
            familyAllowanceDTO.setAllowanceAmount(familyAllowance.getAllowanceAmount());
            familyAllowanceDTO.setSalaryAmount(familyAllowance.getSalaryAmount());
            familyAllowanceDTO.setDateCalculated(familyAllowance.getDateCalculated());
            return familyAllowanceDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping FamilyAllowance to FamilyAllowanceDTO", e);
        }
    }
}
