package co.edu.uniquindio.bikeworkshop.model;

import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {

    @Test
    void registerBike() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
        Client client = workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop);
        Bike bike = workshop.registerBike(2020, "BX", "Red", "73IHDL", BikeType.ELECTRICA, client);

        ArrayList<Bike> testList = new ArrayList<>();
        testList.add(bike);



        assertIterableEquals(testList, workshop.getBikeList());


    }

    @Test
    void registerMechanic() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");

        ArrayList<Mechanic> testList = new ArrayList<>();
        testList.add(workshop.registerMechanic("Foxcobo","esau", MechanicSkillset.FRENOS, workshop));

        assertIterableEquals(testList, workshop.getMechanicList());



    }

    @Test
    void registerClient() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
        ArrayList<Client> testList = new ArrayList<>();

        testList.add(workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop));

        assertIterableEquals(testList, workshop.getClientList());
    }

    @Test
    void createOrder() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
        Client client = workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop);

        ArrayList<Order> testList = new ArrayList<>();
        testList.add(workshop.createOrder(100, LocalDate.of(2020, 10, 10), LocalTime.of(22, 0), "N/A", "N/A", "N/A", workshop, workshop.registerMechanic("Foxcobo","esau", MechanicSkillset.FRENOS, workshop), workshop.registerBike(2020, "BX", "Red", "73IHDL", BikeType.ELECTRICA, client)));

        assertIterableEquals(testList, workshop.getOrderList());
    }

    @Test
    void checkOrderByDate() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
        Client client = workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop);
        Order order = workshop.createOrder(100, LocalDate.of(2020, 10, 10), LocalTime.of(22, 0), "N/A", "N/A", "N/A", workshop, workshop.registerMechanic("Foxcobo","esau", MechanicSkillset.FRENOS, workshop), workshop.registerBike(2020, "BX", "Red", "73IHDL", BikeType.ELECTRICA, client));

        ArrayList<Order> testList = new ArrayList<>();
        testList.add(order);

        assertIterableEquals(testList, workshop.checkOrderByDate(LocalDate.of(2020, 10, 10)));

    }

    @Test
    void russianRoulette() {
        Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
        Client client = workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop);
        Order order = workshop.createOrder(100, LocalDate.of(2020, 10, 10), LocalTime.of(22, 0), "N/A", "N/A", "N/A", workshop, workshop.registerMechanic("Foxcobo","esau", MechanicSkillset.FRENOS, workshop), workshop.registerBike(2020, "BX", "Red", "73IHDL", BikeType.ELECTRICA, client));
        boolean luck = workshop.russianRoulette(order);

        if (luck){
            assertEquals(110, order.getTotalCost());
        }
        else {
            assertEquals(75, order.getTotalCost());
        }
    }
}