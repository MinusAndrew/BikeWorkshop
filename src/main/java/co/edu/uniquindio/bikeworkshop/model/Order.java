package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int totalCost;
    private LocalDate dateOfEntry;
    private LocalTime hour;
    private String reason, diagnosis, workMade;

    // Relationships
    private Workshop theWorkshop;
    private Mechanic theMechanic;
    private Bike theBike;

    public Order(int totalCost, LocalDate dateOfEntry, LocalTime hour, String reason, String diagnosis, String workMade, Workshop theWorkshop, Mechanic theMechanic, Bike theBike) {
        this.totalCost = totalCost;
        this.dateOfEntry = dateOfEntry;
        this.hour = hour;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.workMade = workMade;
        this.theWorkshop = theWorkshop;
        this.theMechanic = theMechanic;
        this.theBike = theBike;
    }

    public Bike getTheBike() {
        return theBike;
    }

    public void setTheBike(Bike theBike) {
        this.theBike = theBike;
    }

    public Mechanic getTheMechanic() {
        return theMechanic;
    }

    public void setTheMechanic(Mechanic theMechanic) {
        this.theMechanic = theMechanic;
    }

    public Workshop getTheWorkshop() {
        return theWorkshop;
    }

    public void setWorkMade(String workMade) {
        this.workMade = workMade;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public LocalTime getHour() {
        return hour;
    }

    public String getReason() {
        return reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getWorkMade() {
        return workMade;
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalCost=" + totalCost +
                ", hour=" + hour +
                ", reason='" + reason + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", workMade='" + workMade + '\'' +
                ", theWorkshop=" + theWorkshop +
                ", theMechanic=" + theMechanic +
                ", theBike=" + theBike +
                '}';
    }
}
