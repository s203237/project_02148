package dk.dtu.project.service;

import org.jspace.Space;
import org.jspace.SequentialSpace;
import org.jspace.ActualField;
import org.jspace.FormalField;

import java.time.LocalDateTime;

public class EventService {
    private Space space;

    public EventService(Space space) {
        this.space = space;
    }
    //Add an event to the space
    public void addEvent(EventTuple event) throws InterruptedException {
        space.put(event.getTitle(), event.getDescription(), event.getDateTime(), event.getLocation(), event.isRecurring());
    }
    //Query an event based on its title
    public EventTuple getEvent(String title) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(Boolean.class));
        return new EventTuple((String) tuple[0], (String) tuple[1], (LocalDateTime) tuple[2], (String) tuple[3], (Boolean) tuple[4]);
    }
    // update an event based on its title
    //first remove the current tuple with the corresponding title
    // then add new tuple to space with updated information
    public void updateEvent(String title, EventTuple updatedEvent) throws InterruptedException {
        space.get(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(Boolean.class));
        space.put(updatedEvent.getTitle(), updatedEvent.getDescription(), updatedEvent.getDateTime(), updatedEvent.getLocation(), updatedEvent.isRecurring());
    }
    // Delete an event based on title
    public void deleteEvent(String title) throws InterruptedException {
        space.get(new ActualField(title), new FormalField(String.class), new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(Boolean.class));
    }
}
