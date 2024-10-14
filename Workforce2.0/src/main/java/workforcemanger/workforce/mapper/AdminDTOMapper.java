package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.AdminDTO;
import workforcemanger.workforce.entity.Admin;

public class AdminDTOMapper {

    public AdminDTOMapper() {}

    public Admin dtoToAdmin(AdminDTO adminDTO) {
        try {
            Admin admin = new Admin();
            admin.setId(adminDTO.getId());
            admin.setUserName(adminDTO.getUserName());
            admin.setEmail(adminDTO.getEmail());
            admin.setRole(adminDTO.getRole());
            return admin;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping AdminDTO to Admin", e);
        }
    }

    public AdminDTO adminToDto(Admin admin) {
        try {
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setId(admin.getId());
            adminDTO.setUserName(admin.getUserName());
            adminDTO.setEmail(admin.getEmail());
            adminDTO.setRole(admin.getRole());
            return adminDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping Admin to AdminDTO", e);
        }
    }
}
