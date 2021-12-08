package com.example.planner;

public class design {
    private int id;
    private String title;
    private String date;
    private String description;
    private String time;



    private String event_type;
    public design(int id, String title, String date, String description, String time, String event_type){
        this.id=id;
        this.title=title;
        this.date=date;
        this.description=description;
        this.time=time;
        this.event_type=event_type;
    }
    public design(String title, String date, String description, String time){
        id=-1;
        this.title=title;
        this.date=date;
        this.description=description;
        this.time=time;
        this.event_type="";
    }
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
    public String getEvent_type() {
        return event_type;
    }
}
