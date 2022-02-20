package com.epharmacy.epharmacy.service;

import com.epharmacy.epharmacy.Repository.TaskRepository;
import com.epharmacy.epharmacy.model.Task;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task){
        taskRepository.save(task);
        return task;
    }

    public List<Task> getTask( ){
        return taskRepository.findAll();
    }
}
