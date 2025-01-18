package dk.dtu.project.controller;
import dk.dtu.project.model.Event;
import dk.dtu.project.model.EventTuple;
import dk.dtu.project.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    // API to create a new event
    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        try {
            eventService.createEvent(event);
            return ResponseEntity.ok("Event created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating event: " + e.getMessage());
        }
    }

    // API to get all events
    @GetMapping
    public ResponseEntity<List<EventTuple>> getAllEvents() {
        try {
            List<EventTuple> events = eventService.getAllEvents();
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // API to get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<EventTuple> getEventById(@PathVariable Long id) {
        try {
            EventTuple eventTuple = eventService.getEventById(id);
            if (eventTuple == null) {
                return ResponseEntity.notFound().build();
            }else{
            return ResponseEntity.ok(eventTuple);}
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);}
    }

    // API to update an event
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        try {
            boolean isUpdated = eventService.updateEvent(id, updatedEvent);
            if (isUpdated) {
                return ResponseEntity.ok("Event updated successfully!");
            } else {
                return ResponseEntity.badRequest().body("Event not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating event: " + e.getMessage());
        }
    }

    // API to delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        try {
            boolean isDeleted = eventService.deleteEvent(id);
            if (isDeleted) {
                return ResponseEntity.ok("Event deleted successfully!");
            } else {
                return ResponseEntity.badRequest().body("Event not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting event: " + e.getMessage());
        }
    }
}

