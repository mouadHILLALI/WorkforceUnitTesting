package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.LeaveRequestDTO;
import workforcemanger.workforce.entity.LeaveRequest;

public class LeaveRequestDTOMapper {

    public LeaveRequestDTOMapper() {}

    public static LeaveRequest dtoToLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
        try {
            LeaveRequest leaveRequest = new LeaveRequest(
                    leaveRequestDTO.getStartDate() , leaveRequestDTO.getEndDate() , leaveRequestDTO.getLeaveReason(), leaveRequestDTO.getStatus(),
                    leaveRequestDTO.getSupportingDocs() , leaveRequestDTO.getLeaveBalance() , leaveRequestDTO.getType() , leaveRequestDTO.getLeaveRequestId()
            );
            return leaveRequest;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping LeaveRequestDTO to LeaveRequest", e);
        }
    }

    public static LeaveRequestDTO leaveRequestToDto(LeaveRequest leaveRequest) {
        try {
            LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(
                    leaveRequest.getLeaveRequestId() , leaveRequest.getStartDate(), leaveRequest.getEndDate() , leaveRequest.getLeaveReason(),
                    leaveRequest.getStatus(),leaveRequest.getSupportingDocs(), leaveRequest.getLeaveBalance(), leaveRequest.getEmployeeId(), leaveRequest.getType()
            );
            return leaveRequestDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping LeaveRequest to LeaveRequestDTO", e);
        }
    }
}
