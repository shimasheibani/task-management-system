package org.taskmanagementsystem.tms.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.taskmanagementsystem.tms.enums.UserType;


import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String family;
    @Column(unique = true)
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date registerDate ;
    private boolean is_active;
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
