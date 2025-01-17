package dk.dtu.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "events")

public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private boolean isRecurring;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructor
    public Event(String title, String description, LocalDateTime dateTime, String location, boolean isRecurring) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
        this.isRecurring = isRecurring;
    }

    public Event() {

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