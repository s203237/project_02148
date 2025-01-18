package dk.dtu.project.service;
import dk.dtu.project.model.Event;
import dk.dtu.project.model.EventTuple;
import dk.dtu.project.repositories.EventRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final JavaMailSender mailSender;

    public EventService(EventRepository eventRepository, JavaMailSender mailSender) {
        this.eventRepository = eventRepository;
        this.mailSender = mailSender;
    }
    public EventTuple toEventTuple(Event event) {
        return new EventTuple(
                event.getTitle(),
                event.getDateTime(),
                event.getLocation()

        );
    }
    // Create a new event
    public void createEvent(Event event) throws InterruptedException {
        eventRepository.saveEvent(event);
    }

    // Get all events
    public List<EventTuple> getAllEvents() throws InterruptedException {
        List<Object[]> tuples = eventRepository.findAllEvents();
        List<EventTuple> events = new ArrayList<>();
        for (Object[] tuple : tuples) {
            events.add(new EventTuple((String) tuple[1], (LocalDateTime) tuple[3], (String) tuple[4]));
        }
        return events;
    }

    // Get event by ID
    public EventTuple getEventById(Long id) throws InterruptedException {
        Object[] tuple = eventRepository.findEventById(id);
        if (tuple != null) {
            return new EventTuple((String) tuple[1], (LocalDateTime) tuple[3], (String) tuple[4]);
        }
        return null;
    }

    // Update an event
    public boolean updateEvent(Long id, Event updatedEvent) throws InterruptedException {
        if (getEventById(id) == null) {
            return false;
        }
        eventRepository.deleteEventById(id);
        eventRepository.saveEvent(updatedEvent);
        return true;
    }

    // Delete an event
    public boolean deleteEvent(Long id) throws InterruptedException {
        if (getEventById(id) == null) {
            return false;
        }
        eventRepository.deleteEventById(id);
        return true;
    }

    // Send email reminder for an event
    public void sendEmailReminder(String recipientEmail, String eventDetails) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipientEmail);
            helper.setSubject("Event Reminder");
            helper.setText(eventDetails);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
