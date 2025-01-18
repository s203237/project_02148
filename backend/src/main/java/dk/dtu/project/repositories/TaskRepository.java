package dk.dtu.project.repositories;

import dk.dtu.project.model.Task;
import dk.dtu.project.model.TaskTuple;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private Space space;

    public TaskRepository(AppSpaceRepository appSpaceRepository) {

        this.space = appSpaceRepository.getRepository().get("tasks");
    }

    // add a task to space
    public void addTask(Task task) throws InterruptedException {
        space.put(task.getId(),task.getTitle(), task.getDescription(), task.getDateTime(), task.getPriority(), task.getCategory());
    }
    // Get all tasks
    public List<Object[]> getAllTasks() throws InterruptedException {
        return space.queryAll(new FormalField(Integer.class), new FormalField(String.class), new FormalField(String.class),
                new FormalField(String.class), new FormalField(String.class), new FormalField(Boolean.class));
    }

    // Get task by ID
    public Object[] getTaskById(long id) throws InterruptedException {
        return space.query(new ActualField(id), new FormalField(String.class), new FormalField(String.class),
                new FormalField(String.class), new FormalField(String.class), new FormalField(Boolean.class));

    }



    // Delete an task by ID
    public void deleteTaskById(Long id) throws InterruptedException {
        space.get(new ActualField(id), new FormalField(String.class), new FormalField(String.class),
                new FormalField(String.class), new FormalField(String.class), new FormalField(Boolean.class));
    }

}
