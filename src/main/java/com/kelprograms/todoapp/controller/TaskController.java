package com.kelprograms.todoapp.controller;

import com.kelprograms.todoapp.entity.Task;
import com.kelprograms.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String rootPage() {
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String showTasks(Model model) {

        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";

    }

    @PostMapping("/createTask")
    public String createTask(@RequestParam(name="title") String title) {

        taskService.createTask(title);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteTask(@PathVariable(name = "id") Integer id, Model model) {

        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable(name = "id") Integer id, Model model) {

        taskService.toggleTask(id);
        return "redirect:/tasks";
    }

}
