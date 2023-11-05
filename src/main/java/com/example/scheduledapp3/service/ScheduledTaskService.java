package com.example.scheduledapp3.service;

import com.example.scheduledapp3.entity.ScheduledTaskEntity;
import com.example.scheduledapp3.repository.ScheduledTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTaskService {

    @Autowired
    private ScheduledTaskRepository taskRepository;

    public List<ScheduledTaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(ScheduledTaskEntity task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


}
