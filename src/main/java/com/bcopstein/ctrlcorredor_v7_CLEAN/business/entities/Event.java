package com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities;

public class Event {
    private int id;
    private String name;
    // Event Date   
    private int day, month, year;
    // Distance Ran
    private int distance; // meters
    // Time took to run the given distance
    private int hours, minutes, seconds;
    
    public Event(int id,String name, int day, int month, int year, int distance, int hours, int minutes, int seconds) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.distance = distance;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDistance() {
        return distance;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return "Event [year=" + year + 
                    ", day=" + day + 
                    ", distance=" + distance + 
                    ", hours=" + hours + 
                    ", id=" + id + 
                    ", month=" + month + 
                    ", minutes=" + minutes + 
                    ", name=" + name + 
                    ", seconds=" + seconds + 
                "]";
    }
}
