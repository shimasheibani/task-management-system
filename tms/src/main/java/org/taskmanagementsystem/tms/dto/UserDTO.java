package org.taskmanagementsystem.tms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.taskmanagementsystem.tms.entities.User;
import org.taskmanagementsystem.tms.enums.UserType;

import java.util.Date;
@Getter
@Setter
public class UserDTO {

    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String family;
    @NotEmpty
    private String email;
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Date registerDate;
    private boolean is_active;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public static User userMapper(UserDTO userDTO){
         User user = User.builder()
                .email(userDTO.email)
                .family(userDTO.family)
                .name(userDTO.name)
                .password(userDTO.password)
                .build();
         return user;
    }

    public static UserDTO userDTOMapper(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setFamily(user.getFamily());
        userDTO.setEmail(user.getEmail());
        userDTO.setRegisterDate(user.getRegisterDate());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }

}
