package dk.dtu.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "events")

public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(length = 500)
    private String description;
    @Column(name = "date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @Column(length = 255)
    private String location;
    @Column(name = "is_recurring")
    private boolean isRecurring;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructor
    public Event(long id,String title, String description, LocalDateTime dateTime, String location, boolean isRecurring) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
        this.isRecurring = isRecurring;
    }

    public Event() {}
    public Long getId(){return id;}
    public void setId(Long id){this.id =id;}
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