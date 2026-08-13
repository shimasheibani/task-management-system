package org.taskmanagementsystem.tms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.taskmanagementsystem.tms.enums.TaskStatus;

import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date dueDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User createdBy;

    @ManyToOne()
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}
