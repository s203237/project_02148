package dk.dtu.project.service;
import java.util.ArrayList;
import java.util.List;
import dk.dtu.project.model.Task;
import dk.dtu.project.model.TaskTuple;
import dk.dtu.project.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository =taskRepository;
    }

    // add a task to space
    public void addTask(Task task) throws InterruptedException {
        taskRepository.addTask(task);}

    // Get all tasks
    public List<TaskTuple> getAllTasks() throws InterruptedException {
        List<Object[]> tuples = taskRepository.getAllTasks();
        List<TaskTuple> tasks = new ArrayList<>();
        for (Object[] tuple : tuples) {
            tasks.add(new TaskTuple((String) tuple[0], (String) tuple[1],  (String) tuple[3], (String) tuple[4]));
        }
        return tasks;
    }

    // Get task by ID
    public TaskTuple getTaskById(long id) throws InterruptedException {
        Object[] tuple = taskRepository.getTaskById(id);
        if (tuple != null) {
            return new TaskTuple((String) tuple[0], (String) tuple[1],  (String) tuple[3], (String) tuple[4]);
        }
        return null;
    }

    // Update an task
    public boolean updateTask(long id, Task updatedTask) throws InterruptedException {
        if (getTaskById(id) == null) {
            return false;
        }
        taskRepository.deleteTaskById(id);
        taskRepository.addTask(updatedTask);
        return true;
    }

    // Delete an task
    public boolean deleteTask(Long id) throws InterruptedException {
        if (getTaskById(id) == null) {
            return false;
        }
        taskRepository.deleteTaskById(id);
        return true;
    }
}

