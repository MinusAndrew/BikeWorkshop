package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;

public class Mechanic {
    private String fullName, internalId;
    private MechanicSkillset mechanicSkillset;
    private Workshop theWorkshop;

    // Relationships
    private Order theOrder;

    public Mechanic(String fullName, String internalId, MechanicSkillset mechanicSkillset, Workshop theWorkshop) {
        this.fullName = fullName;
        this.internalId = internalId;
        this.mechanicSkillset = mechanicSkillset;
        this.theWorkshop = theWorkshop;
    }

    public Order getTheOrder() {
        return theOrder;
    }

    public void setTheOrder(Order theOrder) {
        this.theOrder = theOrder;
    }

    public String getInternalId() {
        return internalId;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "fullName='" + fullName + '\'' +
                ", internalId='" + internalId + '\'' +
                ", mechanicSkillset=" + mechanicSkillset +
                ", theOrder=" + theOrder +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public MechanicSkillset getMechanicSkillset() {
        return mechanicSkillset;
    }

    public Workshop getTheWorkshop() {
        return theWorkshop;
    }
}
