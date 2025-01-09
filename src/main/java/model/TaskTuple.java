package model;
import java.time.LocalDateTime;

public class TaskTuple extends BaseItemTuple {
    private String priority;
    private String category;

    // Constructor
    public TaskTuple(String title, String description, LocalDateTime dateTime, String priority, String category) {
        super(title, description, dateTime);
        this.priority = priority;
        this.category = category;
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
