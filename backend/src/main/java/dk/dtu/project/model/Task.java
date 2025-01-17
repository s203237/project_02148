package dk.dtu.project.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String priority;
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Constructor
    public Task(String title, String description, LocalDateTime dateTime, String priority, String category) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.priority = priority;
        this.category = category;
    }

    public Task() {}

    // Getters and setters
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