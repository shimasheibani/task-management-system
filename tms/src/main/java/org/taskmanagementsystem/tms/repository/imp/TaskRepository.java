package org.taskmanagementsystem.tms.repository.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskmanagementsystem.tms.entities.Project;
import org.taskmanagementsystem.tms.entities.Task;
import org.taskmanagementsystem.tms.entities.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAssignee(User user);
    List<Task> findByProject(Project project);

}
