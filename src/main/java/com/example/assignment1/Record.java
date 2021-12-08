package com.example.assignment1;

import java.io.Serializable;

public class Record implements Serializable {

    private String PPS;
    private String date;
    private String type;

    public Record(String PPS, String date, String type){

        this.PPS = PPS;

        this.date = date;

        this.type = type;

    }

    public String getPPS() {
        return PPS;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setPPS(String PPS) {
        this.PPS = PPS;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    //delete && make the record
}
