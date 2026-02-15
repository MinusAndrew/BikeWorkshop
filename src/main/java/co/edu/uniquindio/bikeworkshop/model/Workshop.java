package co.edu.uniquindio.bikeworkshop.model;

import java.util.ArrayList;

public class Workshop {
    private String name, nit;

    //Relationships
    private ArrayList<Order> orderList;
    private ArrayList<Bike> bikeList;
    private ArrayList<Client> clientList;

    public Workshop(String name, String nit) {
        this.name = name;
        this.nit = nit;
        this.bikeList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.clientList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Bike> getBikeList() {
        return bikeList;
    }

    public String getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

}
