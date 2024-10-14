package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.UserDTO;
import workforcemanger.workforce.entity.User;

public class UserDTOMapper {
    public UserDTOMapper(){}

    public User DtoToUser(UserDTO userDTO) {
        try {
            User user = new User(
                    userDTO.getId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getRole()
            );
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping UserDTO to User", e);
        }
    }

    public UserDTO UserToDto(User user) {
        try {
            UserDTO userDTO = new UserDTO(
                    user.getId(),  user.getUserName(), user.getEmail(), user.getRole(), user.getPhone(), user.getPassword()
            );
            return userDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping User to UserDTO", e);
        }
    }
}
