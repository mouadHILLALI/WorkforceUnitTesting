package workforcemanger.workforce.service.LeaveRequestService;

import workforcemanger.workforce.dto.LeaveRequestDTO;
import workforcemanger.workforce.mapper.LeaveRequestDTOMapper;
import workforcemanger.workforce.repository.LeaveRequest.LeaveRequestRepositoryImpl;

public class LeaveRequestService {
    final LeaveRequestRepositoryImpl leaveRequestRepository = new LeaveRequestRepositoryImpl();
    public LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
        try {
            return LeaveRequestDTOMapper.leaveRequestToDto(LeaveRequestDTOMapper.dtoToLeaveRequest(leaveRequestRepository.create(leaveRequestDTO)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
