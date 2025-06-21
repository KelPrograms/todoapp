package com.kelprograms.todoapp.service;

import com.kelprograms.todoapp.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    void createTask(String title);
    void deleteTask(Integer id);
    void toggleTask(Integer id);
}
