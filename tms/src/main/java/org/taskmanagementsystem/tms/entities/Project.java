package org.taskmanagementsystem.tms.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "user_id" )
    private User createdBy;
}
