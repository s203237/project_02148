package main.java.model;

import model.BaseItem;

import java.time.LocalDateTime;

public class Event extends BaseItem {
    private String location;
    private boolean isRecurring;

    // Constructor
    public Event(String title, String description, LocalDateTime dateTime, String location, boolean isRecurring) {
        super(title, description, dateTime);
        this.location = location;
        this.isRecurring = isRecurring;
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