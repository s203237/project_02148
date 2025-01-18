package dk.dtu.project.repositories;

import dk.dtu.project.model.Event;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository {

    private final Space space;

    public EventRepository(AppSpaceRepository appSpaceRepository) {
        this.space = appSpaceRepository.getRepository().get("events");
    }

    // Save new event to Space
    public void saveEvent(Event event) throws InterruptedException {
        space.put(event.getId(), event.getTitle(), event.getDescription(), event.getDateTime(),
                event.getLocation(), event.isRecurring());
    }

    // Query all events
    public List<Object[]> findAllEvents() throws InterruptedException {
        return space.queryAll(new FormalField(Long.class), new FormalField(String.class),
                new FormalField(String.class), new FormalField(LocalDateTime.class),
                new FormalField(String.class), new FormalField(Boolean.class));
    }

    // Query events by ID
    public Object[] findEventById(Long id) throws InterruptedException {
        return space.query(new ActualField(id), new FormalField(String.class),
                new FormalField(String.class), new FormalField(LocalDateTime.class),
                new FormalField(String.class), new FormalField(Boolean.class));
    }


    // Delete event by ID
    public void deleteEventById(Long id) throws InterruptedException {
        space.get(new ActualField(id), new FormalField(String.class), new FormalField(String.class),
                new FormalField(LocalDateTime.class), new FormalField(String.class), new FormalField(Boolean.class));
    }
}