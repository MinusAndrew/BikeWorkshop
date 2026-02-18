package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public Bike registerBike(int year, String brand, String color, String serialId, BikeType bikeType, Client theClient) {
        Bike bike = new Bike(year, brand, color, serialId, bikeType, theClient);
        bikeList.add(bike);
        theClient.getBikeList().add(bike);
        return bike;
    }

    public Mechanic registerMechanic(String fullName, String internalId, MechanicSkillset mechanicSkillset, Workshop theWorkshop) {
        Mechanic mechanic = new Mechanic(fullName, internalId, mechanicSkillset, theWorkshop);
        mechanicList.add(mechanic);
        return mechanic;
    }

    public Client registerClient(String name, String id, String phoneNumber, String address, Workshop theWorkshop) {
        Client client = new Client(name, id, phoneNumber, address, theWorkshop);
        clientList.add(client);
        return client;
    }

    public Order createOrder(int totalCost, LocalDate dateOfEntry, LocalTime hour, String reason, String diagnosis, String workMade, Workshop theWorkshop, Mechanic theMechanic, Bike theBike) {
        Order order = new Order(totalCost, dateOfEntry, hour, reason, diagnosis, workMade, theWorkshop, theMechanic, theBike);
        orderList.add(order);
        theBike.setTheOrder(order);
        theMechanic.setTheOrder(order);
        return order;
    }

    public ArrayList<Order> checkOrderByDate(LocalDate date) {
        ArrayList<Order> newList = new ArrayList<>();
        for (Order order : orderList){
            if (order.getDateOfEntry().isEqual(date)){
                newList.add(order);
            }
        }
        return newList;
    }

    public boolean russianRoulette(Order order) {
        double bullet = Math.random()*10;
        int price = order.getTotalCost();
        if(bullet < (double)10/6){
            order.setTotalCost(price + (int)(price*0.1));
            System.out.println("+10%");
            return true;
        } else {
            order.setTotalCost(price - (int)(price*0.25));
            System.out.println("-25%");
            return false;
        }
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Bike> getBikeList() {
        return bikeList;
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public String getName() {
        return name;
    }

    public String getNit() {
        return nit;
    }
}

