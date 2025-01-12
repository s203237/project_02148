package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseItemTuple implements Serializable {
    private String title;
    private String description;
    private LocalDateTime dateTime;

    // Constructor
    public BaseItemTuple(String title, String description, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    // Getters và setters
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
}