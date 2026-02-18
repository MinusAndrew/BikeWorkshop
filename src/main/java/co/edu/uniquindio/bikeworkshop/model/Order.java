package co.edu.uniquindio.bikeworkshop.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int totalCost;
    private LocalDate dateOfEntry;
    private LocalTime hourOfEntry;
    private String reason, diagnosis, workMade;

    // Relationships
    private Workshop theWorkshop;
    private Mechanic theMechanic;
    private Bike theBike;

    public Order(int totalCost, LocalDate dateOfEntry, LocalTime hourOfEntry, String reason, String diagnosis, String workMade, Workshop theWorkshop, Mechanic theMechanic, Bike theBike) {
        this.totalCost = totalCost;
        this.dateOfEntry = dateOfEntry;
        this.hourOfEntry = hourOfEntry;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.workMade = workMade;
        this.theWorkshop = theWorkshop;
        this.theMechanic = theMechanic;
        this.theBike = theBike;
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

    public String getWorkMade() {
        return workMade;
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalCost=" + totalCost +
                ", hourOfEntry=" + hourOfEntry +
                ", reason='" + reason + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", workMade='" + workMade + '\'' +
                ", theWorkshop=" + theWorkshop +
                ", theMechanic=" + theMechanic +
                ", theBike=" + theBike +
                '}';
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public LocalTime getHourOfEntry() {
        return hourOfEntry;
    }

    public String getReason() {
        return reason;
    }

    public Bike getTheBike() {
        return theBike;
    }

    public Mechanic getTheMechanic() {
        return theMechanic;
    }
}
