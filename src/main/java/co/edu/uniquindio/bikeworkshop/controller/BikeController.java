package co.edu.uniquindio.bikeworkshop.controller;

import co.edu.uniquindio.bikeworkshop.model.Bike;
import co.edu.uniquindio.bikeworkshop.model.Client;
import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
import co.edu.uniquindio.bikeworkshop.model.Workshop;

import java.util.ArrayList;

public class BikeController {

    public ArrayList<Bike> bikeList(Workshop theWorkshop){
        return theWorkshop.getBikeList();
    }

    public boolean checkBikeSerial(Workshop theWorkshop, String serialId){
        return theWorkshop.getBikeList().stream()
                .anyMatch(bike -> bike.getSerialId().equalsIgnoreCase(serialId));
    }

    public Client searchClient(Workshop theWorkshop, String id){
        for (Client client : theWorkshop.getClientList()){
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    public Bike addBike(Workshop theWorkshop, int year, String brand, String color, String serialId, BikeType bikeType, Client theClient){
        return theWorkshop.registerBike(year, brand, color, serialId, bikeType, theClient);
    }

}
