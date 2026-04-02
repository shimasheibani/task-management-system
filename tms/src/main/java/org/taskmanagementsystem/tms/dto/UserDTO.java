package org.taskmanagementsystem.tms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.taskmanagementsystem.tms.enumUser.UserType;

import java.util.Date;

public class UserDTO {

    private Long id;

    private String name;
    private String family;

    private String email;
    @JsonIgnore
    private String password;

    private Date registerDate;
    private boolean is_active;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
