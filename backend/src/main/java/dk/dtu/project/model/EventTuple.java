package dk.dtu.project.model;
import java.time.LocalDateTime;

public class EventTuple{
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private boolean isRecurring;

    // Constructor
    public EventTuple(String title, String description, LocalDateTime dateTime, String location, boolean isRecurring) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
        this.isRecurring = isRecurring;
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
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }
}