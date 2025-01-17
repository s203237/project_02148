package dk.dtu.project.model;
import java.time.LocalDateTime;

public class TaskTuple {
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String priority;
    private String category;

    // Constructor
    public TaskTuple(String title, String description, LocalDateTime dateTime, String priority, String category) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
