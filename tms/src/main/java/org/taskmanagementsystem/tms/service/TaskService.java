package org.taskmanagementsystem.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskmanagementsystem.tms.entities.Task;
import org.taskmanagementsystem.tms.entities.User;
import org.taskmanagementsystem.tms.enums.TaskStatus;
import org.taskmanagementsystem.tms.repository.imp.TaskRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(Task task){
        task.setCreatedAt(new Date(System.currentTimeMillis()));
        if(task.getTaskStatus()==null){
            task.setTaskStatus(TaskStatus.TODO);
        }
        return taskRepository.save(task);
    }

    public Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public List<Task> fidnByAssignee(User user){
        return taskRepository.findByAssignee(user);
    }

    public void updateTaskStatus(Long id, TaskStatus status){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTaskStatus(status);
        taskRepository.save(task);

    }

    public void deleteTasl(Long id){
        taskRepository.deleteById(id);
    }


}
