package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;

public class Bike {

    private int year;
    private String brand, color, serialId;
    private BikeType bikeType;

    // Relationships
    private Client theClient;

    private Order theOrder;

    private Workshop theWorkshop;

    public Bike(int year, String brand, String color, String serialId, BikeType bikeType, Client theClient, Workshop theWorkshop) {
        this.year = year;
        this.brand = brand;
        this.color = color;
        this.serialId = serialId;
        this.bikeType = bikeType;
        this.theClient = theClient;
        this.theWorkshop = theWorkshop;
    }

    public Workshop getTheWorkshop() {
        return theWorkshop;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
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

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }
}
