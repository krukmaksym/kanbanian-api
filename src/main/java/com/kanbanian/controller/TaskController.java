package com.kanbanian.controller;

import com.kanbanian.entity.Task;
import com.kanbanian.entity.TaskList;
import com.kanbanian.repository.TaskListRepo;
import com.kanbanian.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/task")
public class TaskController {

    final TaskRepo taskRepo;

    @Autowired
    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping
    Iterable getTask(){
        return taskRepo.findAll();
    }

    @GetMapping("{id}")
    Task getTaskById(@PathVariable("id") Task task) {
        return task;
    }

    @PostMapping()
    Task createTask(@RequestBody Task task) {
        task.setDateTime(LocalDateTime.now());
        return taskRepo.save(task);
    }

    @PutMapping("{id}")
    Task updateTask(
            @PathVariable("id") Task oldTask,
            @RequestBody Task newTask) {
        if (oldTask.getName() != null) {
            oldTask.setName(newTask.getName());
        }

        if (oldTask.getDescription() != null) {
            oldTask.setDescription(newTask.getDescription());
        }

        if (oldTask.getAttachment() != null) {
            oldTask.setAttachment(newTask.getAttachment());
        }

        if (oldTask.getDateTime() != null) {
            oldTask.setDateTime(newTask.getDateTime());
        }

        return taskRepo.save(oldTask);
    }

    @DeleteMapping("{id}")
    void deleteTask(@PathVariable("id") Task task) {
        taskRepo.delete(task);
    }
}
