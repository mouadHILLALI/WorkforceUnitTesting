package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.HrDTO;
import workforcemanger.workforce.entity.HR;

public class HrDTOMapper {

    public HrDTOMapper() {}

    public HR dtoToHr(HrDTO hrDTO) {
        try {
            HR hr = new HR();
            hr.setId(hrDTO.getId());
            hr.setUserName(hrDTO.getUserName());
            hr.setEmail(hrDTO.getEmail());
            hr.setPhone(hrDTO.getPhone());
            return hr;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping HrDTO to Hr", e);
        }
    }

    public HrDTO hrToDto(HR hr) {
        try {
            HrDTO hrDTO = new HrDTO();
            hrDTO.setId(hr.getId());
            hrDTO.setUserName(hr.getUserName());
            hrDTO.setEmail(hr.getEmail());
            hrDTO.setPhone(hr.getPhone());
            return hrDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping Hr to HrDTO", e);
        }
    }
}
