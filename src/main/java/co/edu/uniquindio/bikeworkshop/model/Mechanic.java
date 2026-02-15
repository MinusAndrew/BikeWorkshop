package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;

public class Mechanic {
    private String fullName, internalId;
    private MechanicSkillset mechanicSkillset;

    // Relationships
    private Order theOrder;

    public Mechanic(String fullName, String internalId, MechanicSkillset mechanicSkillset) {
        this.fullName = fullName;
        this.internalId = internalId;
        this.mechanicSkillset = mechanicSkillset;
    }

    public Order getTheOrder() {
        return theOrder;
    }

    public void setTheOrder(Order theOrder) {
        this.theOrder = theOrder;
    }

    public MechanicSkillset getMechanicSkillset() {
        return mechanicSkillset;
    }

    public void setMechanicSkillset(MechanicSkillset mechanicSkillset) {
        this.mechanicSkillset = mechanicSkillset;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}
