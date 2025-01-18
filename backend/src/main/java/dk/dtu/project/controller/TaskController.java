package dk.dtu.project.controller;

import dk.dtu.project.model.Task;
import dk.dtu.project.model.TaskTuple;
import dk.dtu.project.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService =taskService;
    }
    // API to create a new task
    @PostMapping("/create")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        try {
            taskService.addTask(task);
            return ResponseEntity.ok("Task created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating task: " + e.getMessage());
        }
    }
    // API to get all events
    @GetMapping
    public ResponseEntity<List<TaskTuple>> getAllTasks() {
        try {
            List<TaskTuple> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    // API to get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskTuple> getTaskById(@PathVariable Long id) {
        try {
            TaskTuple task = taskService.getTaskById(id);
            if (task != null) {
                return ResponseEntity.ok(task);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // API to update a task
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        try {
            boolean isUpdated = taskService.updateTask(id,updatedTask);
            if (isUpdated) {
                return ResponseEntity.ok("Task updated successfully!");
            } else {
                return ResponseEntity.badRequest().body("Task not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating task: " + e.getMessage());
        }
    }

    // API to delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        try {
            boolean isDeleted = taskService.deleteTask(id);
            if (isDeleted) {
                return ResponseEntity.ok("Task deleted successfully!");
            } else {
                return ResponseEntity.badRequest().body("Task not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting task: " + e.getMessage());
        }
    }

}
