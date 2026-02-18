package co.edu.uniquindio.bikeworkshop.model;

import java.util.ArrayList;

public class Client{
    private String name, id, phoneNumber, address;

    //Relationships

    private Workshop theWorkshop;
    private ArrayList<Order> orderList;
    private ArrayList<Bike> bikeList;

    public Client(String name, String id, String phoneNumber, String address, Workshop theWorkshop) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.theWorkshop = theWorkshop;
        this.orderList = new ArrayList<>();
        this.bikeList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Bike> getBikeList() {
        return bikeList;
    }

    public Workshop getTheWorkshop() {
        return theWorkshop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", theWorkshop=" + theWorkshop +
                ", orderList=" + orderList +
                ", bikeList=" + bikeList +
                '}';
    }
}
