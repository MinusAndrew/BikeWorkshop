package co.edu.uniquindio.bikeworkshop.controller;

import co.edu.uniquindio.bikeworkshop.model.Client;
import co.edu.uniquindio.bikeworkshop.model.Workshop;

import java.util.ArrayList;

public class ClientController {

    public ArrayList<Client> clientList(Workshop theWorkshop){
        return theWorkshop.getClientList();
    }

    public boolean checkClientId(Workshop theWorkshop, String id){
        return theWorkshop.getClientList().stream()
                .anyMatch(c -> c.getId().equalsIgnoreCase(id));
    }

    //this mess
    public Client addClient(Workshop theWorkshop, String name, String id, String phoneNum, String address){
        return theWorkshop.registerClient(name, id, phoneNum, address, theWorkshop);
    }


}
