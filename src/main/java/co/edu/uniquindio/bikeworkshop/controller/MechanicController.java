package co.edu.uniquindio.bikeworkshop.controller;

import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;
import co.edu.uniquindio.bikeworkshop.model.Mechanic;
import co.edu.uniquindio.bikeworkshop.model.Workshop;

import java.util.ArrayList;

public class MechanicController {

    public ArrayList<Mechanic> mechanicList(Workshop theWorkshop) {
        return theWorkshop.getMechanicList();
    }

    public boolean checkMechanicId(Workshop theWorkshop, String internalId){
        return theWorkshop.getMechanicList().stream()
                .anyMatch(m -> m.getInternalId().equalsIgnoreCase(internalId));
    }

    public Mechanic addMechanic(Workshop theWorkshop, String fullName, String internalId, MechanicSkillset mechanicSkillset){
        return theWorkshop.registerMechanic(fullName, internalId, mechanicSkillset, theWorkshop);
    }
}
