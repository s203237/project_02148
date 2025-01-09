package model;


import java.time.LocalDateTime;

public class Event {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
//constructor
    public Event(String title, String description, LocalDateTime startTime, LocalDateTime endTime){
        this.title =title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle( String title){
        this.title =title;
    }
    public String getDescription(){
        return description;
    }
    public LocalDateTime getStartTime(){
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }
}
