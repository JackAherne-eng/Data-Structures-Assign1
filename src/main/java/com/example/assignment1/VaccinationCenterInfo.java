package com.example.assignment1;

public class VaccinationCenterInfo {

    private String name;
    private String address;
    private String eircode;
    private int p_space;
    private LinkedListCreation<Booth> listB = new LinkedListCreation<>();


    public VaccinationCenterInfo(String name, String address, String eircode, int p_space){

        this.name = name;

        this.address = address;

        this.eircode = eircode;

        this.p_space = p_space;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEircode() {
        return eircode;
    }

    public int getP_space() {
        return p_space;
    }

    public LinkedListCreation<Booth> getListB() {
        return listB;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setP_space(int p_space) {
        this.p_space = p_space;
    }

    public void setListB(LinkedListCreation<Booth> listB) {
        this.listB = listB;
    }
}
