package com.example.assignment1;

import java.io.Serializable;

public class Appointment implements Serializable {

    private String date;
    private String time;
    private String type;
    private String bNum;
    private String details;
    private String PPS;

    public Appointment(String date, String time, String type, String bNum, String details, String PPS){

        this.date = date;

        this.time = time;

        this.type = type;

        this.bNum = bNum;

        this.details = details;

        this.PPS = PPS;
    }

    public String getDate() {return date;}

    public String getTime() {return time;}

    public String getType() {return type;}


    public String getbNum() {return bNum;}


    public String getDetails() {return details;}


    public String getPPS() {return PPS;}



    public void setDate(String date) {this.date = date;}


    public void setTime(String time) {this.time = time;}

    public void setType(String type) {this.type = type;}

    public void setbNum(String bNum) {this.bNum = bNum;}

    public void setDetails(String details) {this.details = details;}

    public void setPPS(String PPS) {this.PPS = PPS;}
}
