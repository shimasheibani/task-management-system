package org.taskmanagementsystem.tms.repository.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskmanagementsystem.tms.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
