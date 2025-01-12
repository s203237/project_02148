package service;
import java.time.LocalDateTime;

import model.EventTuple;
import model.TaskTuple;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;

public class TaskService {
    private Space space;

    public TaskService(Space space) {
        this.space = space;
    }
    // add a task to space
    public void addTask(TaskTuple task) throws InterruptedException {
        space.put(task.getTitle(), task.getDescription(), task.getDateTime(), task.getPriority(), task.getCategory());
    }
    //Query a task based on title
    public TaskTuple getTask(String title) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(String.class));
        return new TaskTuple((String) tuple[0], (String) tuple[1], (LocalDateTime) tuple[2], (String) tuple[3], (String) tuple[4]);
    }
    // update a task based on its title
    //first remove the current tuple with the corresponding title
    // then add new tuple to space with updated information
    public void updateTask(String title, TaskTuple updatedTask) throws InterruptedException {
        space.get(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(String.class));
        space.put(updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.getDateTime(), updatedTask.getPriority(), updatedTask.getCategory());
    }
    // delete a task based on its title
    public void deleteTask(String title) throws InterruptedException {
        space.get(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(String.class));
    }
}

