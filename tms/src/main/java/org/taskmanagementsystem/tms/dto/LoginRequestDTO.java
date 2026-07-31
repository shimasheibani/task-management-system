package org.taskmanagementsystem.tms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
