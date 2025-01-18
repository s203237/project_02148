package dk.dtu.project.model;
import java.time.LocalDateTime;

public class TaskTuple {
    private String title;
    private String description;
    private String priority;
    private String category;

    // Constructor
    public TaskTuple(String title, String description, String priority, String category) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
