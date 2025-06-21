package com.kelprograms.todoapp.service;

import com.kelprograms.todoapp.entity.Task;
import com.kelprograms.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks (){
         return taskRepository.findAll();
    }

    public void createTask(String title) {

        Task task = new Task(null,false, title);
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void toggleTask(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Task id"));

        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
