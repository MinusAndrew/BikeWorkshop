package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workshop {
    private String name, nit;

    //Relationships
    private ArrayList<Order> orderList;
    private ArrayList<Bike> bikeList;
    private ArrayList<Client> clientList;
    private ArrayList<Mechanic> mechanicList;

    public Workshop(String name, String nit) {
        this.name = name;
        this.nit = nit;
        this.bikeList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.clientList = new ArrayList<>();
        this.mechanicList = new ArrayList<>();
    }

    public void registerBike(int year, String brand, String color, String serialId, BikeType bikeType, Client theClient, Workshop theWorkshop) {
        Bike bike = new Bike(year, brand, color, serialId, bikeType, theClient, theWorkshop);
        bikeList.add(bike);
    }

    public void registerMechanic(String fullName, String internalId, MechanicSkillset mechanicSkillset) {
        Mechanic mechanic = new Mechanic(fullName, internalId, mechanicSkillset);
        mechanicList.add(mechanic);
    }

    public void registerClient(String name, String id, String phoneNumber, String address, Workshop theWorkshop) {
        Client client = new Client(name, id, phoneNumber, address, theWorkshop);
        clientList.add(client);
    }

    public void createOrder(int totalCost, LocalDate dateOfEntry, LocalDate hour, String reason, String diagnosis, String workMade, Workshop theWorkshop, Mechanic theMechanic, Bike theBike) {
        Order order = new Order(totalCost, dateOfEntry, hour, reason, diagnosis, workMade, theWorkshop, theMechanic, theBike);
        orderList.add(order);
    }

    public void checkOrderByDate (LocalDate date) {
        for(Order order : orderList){
            if(order.getDateOfEntry().isEqual(date)){
                System.out.println(order);
            }
        }
    }

    public void russianRoulette(Order order) {
        double bullet = Math.random()*10;
        int price = order.getTotalCost();
        if(bullet < (double)10/6){
            order.setTotalCost(price + (int)(price*0.1));
            System.out.println("+10%");
        } else {
            order.setTotalCost(price - (int)(price*0.25));
            System.out.println("-25%");
        }
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
}

