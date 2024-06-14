package com.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.entity.Tasks;
import com.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TaskController {

    @Autowired
    private TaskService taskService;

    //get all tasks
    @GetMapping("/tasks")
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    //add task by user id
    @PostMapping("/tasks/{id}")
    public Tasks postTask(@PathVariable Long id, @RequestBody Tasks task) {
        return taskService.postTask(id, task);
    }

    // @PostMapping("/tasks/{userId}")
    // public ResponseEntity<Tasks> postTask(@PathVariable Long userId, @RequestBody Tasks task) {
    //     Tasks createdTask = taskService.postTask(userId, task);
    //     if (createdTask != null) {
    //         return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }
    // }

    //get Task by user id
    @GetMapping("/gettasks/{userId}")
    public ResponseEntity<List<Tasks>> getTaskById(@PathVariable Long userId) {
        List<Tasks> task = taskService.getTaskById(userId);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    //get Task by user id
    @GetMapping("/gettasks/{userId}/{taskId}")
    public ResponseEntity<Tasks> getTaskByUserIdAndTaskId(@PathVariable Long userId,@PathVariable Long taskId) {
        Tasks task = taskService.getTaskByUserIdAndTaskId(userId,taskId);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/deletetask/{id}/{taskId}")
    public ResponseEntity<List<Tasks>> deleteTaskById(@PathVariable Long id,@PathVariable Long taskId) {
        List<Tasks> task = taskService.deleteTask(id,taskId);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
        // return ResponseEntity.noContent().build();
    }


    @PutMapping("/updatetask/{id}/{taskId}")
    public ResponseEntity<List<Tasks>> updateTask(@PathVariable Long id, @PathVariable Long taskId, @RequestBody Tasks task) {
        List<Tasks> updatedTask = taskService.updateTask(id, taskId, task);
        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
    }
}
