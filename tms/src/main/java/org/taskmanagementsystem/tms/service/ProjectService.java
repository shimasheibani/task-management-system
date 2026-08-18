package org.taskmanagementsystem.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskmanagementsystem.tms.entities.Project;
import org.taskmanagementsystem.tms.repository.imp.ProjectRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project createProject(Project project){
        project.setCreatedDate(new Date(System.currentTimeMillis()));
        return projectRepository.save(project);}
    public List<Project> findAllProject(){ return projectRepository.findAll();}
    public Optional<Project> findById(Long id){ return projectRepository.findById(id);}
    public void deletProject (Long id){projectRepository.deleteById(id);}

}
