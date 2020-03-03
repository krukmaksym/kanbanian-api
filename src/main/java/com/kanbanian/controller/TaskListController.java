package com.kanbanian.controller;

import com.kanbanian.entity.Board;
import com.kanbanian.entity.TaskList;
import com.kanbanian.repository.BoardRepo;
import com.kanbanian.repository.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskListController {
    final TaskListRepo taskListRepo;
    final BoardRepo boardRepo;

    @Autowired
    public TaskListController(TaskListRepo taskListRepo, BoardRepo boardRepo) {
        this.taskListRepo = taskListRepo;
        this.boardRepo = boardRepo;
    }

    @GetMapping
    Iterable getAllTasksLists() {
        return taskListRepo.findAll();
    }

    @GetMapping("{id}")
    TaskList getTaskListById(@PathVariable TaskList taskList) {
        return taskList;
    }

    @PostMapping
    TaskList creteTaskList(@RequestBody Map<String, String> requestBody) {
        TaskList taskList = new TaskList();
        taskList.setName(requestBody.get("name"));
        Board board = boardRepo.findById(Long.parseLong(requestBody.get("boardId"))).get();
        taskList.setBoard(board);
        return taskListRepo.save(taskList);
    }

    @PutMapping("{id}")
    TaskList updateTaskList(
            @PathVariable("id") TaskList oldTaskList,
            @RequestBody TaskList newTaskList) {
        if (oldTaskList.getName() != null) {
            oldTaskList.setName(newTaskList.getName());
        }

        if (oldTaskList.getTasks() != null) {
            oldTaskList.setTasks(newTaskList.getTasks());
        }

       return taskListRepo.save(oldTaskList);
    }

    @DeleteMapping("{id}")
    void deleteTaskList(@PathVariable("id") TaskList taskList) { taskListRepo.delete(taskList); }
}
