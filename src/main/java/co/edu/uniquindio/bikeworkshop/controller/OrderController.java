package co.edu.uniquindio.bikeworkshop.controller;

import co.edu.uniquindio.bikeworkshop.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OrderController {
    public ArrayList<Mechanic> grabFreeMechanicList(Workshop theWorkshop){
        ArrayList<Mechanic> allMechList = theWorkshop.getMechanicList();

        ArrayList<Mechanic> newList = new ArrayList<>();

        for (Mechanic mechanic : allMechList){
            if (mechanic.getTheOrder() == null){
                newList.add(mechanic);
            }
        }

        return newList;
    }

    public Order addOrder(Workshop theWorkshop, LocalDate date, LocalTime hour, String reason, String diagnosis, String workMade, int totalCost, Mechanic theMechanic, Bike theBike){
        return theWorkshop.createOrder(totalCost, date, hour, reason, diagnosis, workMade, theWorkshop, theMechanic, theBike);
    }

    public Client searchClientById(String id, Workshop theWorkshop){
        for (Client client : theWorkshop.getClientList()){
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    public ArrayList<Order> orderList(Workshop theWorkshop){
        return theWorkshop.getOrderList();
    }

    public boolean checkMechanic(Mechanic mechanic){
        return mechanic.getTheOrder() != null;
    }

}
