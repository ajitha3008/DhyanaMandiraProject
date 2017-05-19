package com.braingalore.dhyanamandira.model;

/**
 * Created by s92 on 5/8/2017.
 */

public class EventsObject {
    private String eventName, eventLocation, eventDate, eventDescription;

    public EventsObject() {
    }

    public EventsObject(String name, String loc, String date, String description) {
        this.eventName = name;
        this.eventLocation = loc;
        this.eventDate = date;
        this.eventDescription = description;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String name) {
        this.eventName = name;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String location) {
        this.eventLocation = location;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String date) {
        this.eventDate = date;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String desc) {
        this.eventDescription = desc;
    }
}
