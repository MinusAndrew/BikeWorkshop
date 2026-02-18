package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;

public class Bike {

    private int year;
    private String brand, color, serialId;
    private BikeType bikeType;

    // Relationships
    private Client theClient;

    private Order theOrder;

    public Bike(int year, String brand, String color, String serialId, BikeType bikeType, Client theClient) {
        this.year = year;
        this.brand = brand;
        this.color = color;
        this.serialId = serialId;
        this.bikeType = bikeType;
        this.theClient = theClient;
    }

    public Client getTheClient() {
        return theClient;
    }

    public void setTheClient(Client theClient) {
        this.theClient = theClient;
    }

    public Order getTheOrder() {
        return theOrder;
    }

    public void setTheOrder(Order theOrder) {
        this.theOrder = theOrder;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }


    public String getSerialId() {
        return serialId;
    }

}
