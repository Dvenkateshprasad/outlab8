package com.example.planner;

public class design {
    private String title;
    private String date;
    private String description;
    private String time;
    public design(String title, String date, String description, String time){
        this.title=title;
        this.date=date;
        this.description=description;
        this.time=time;
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
}
