package com.example.assignment1;

public class Patient {

    private String name;
    private String PPS;
    private String doB;
    private int phoneNum;
    private String email;
    private String accRelate;
    private LinkedListCreation<Appointment> listA = new LinkedListCreation<>();

    public Patient(String name, int phoneNum, String doB, String email, String PPS, String accRelate){

        this.name = name;

        this.phoneNum = phoneNum;

        this.doB = doB;

        this.email = email;

        this.PPS = PPS;

        this.accRelate = accRelate;
    }

    public LinkedListCreation<Appointment> getListA() {
        return listA;
    }

    public String getName() { return name; }

    public String getPPS() {
        return PPS;
    }

    public String getDoB() {
        return doB;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getAccRelate() {
        return accRelate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPPS(String PPS) {
        this.PPS = PPS;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccRelate(String accRelate) {
        this.accRelate = accRelate;
    }

    public void setListA(LinkedListCreation<Appointment> listA) {
        this.listA = listA;
    }

}
