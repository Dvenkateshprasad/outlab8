package com.example.planner;

public class design {

    private int itemid;
    private String title;
    private String date;
    private String description;
    private String time;
    public design(int id,String title, String date, String description, String time){
        this.itemid = id;
        this.title=title;
        this.date=date;
        this.description=description;
        this.time=time;
    }
    public int getItemid(){return itemid;}
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
