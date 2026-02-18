package co.edu.uniquindio.bikeworkshop.controller;

import co.edu.uniquindio.bikeworkshop.model.Order;
import co.edu.uniquindio.bikeworkshop.model.Workshop;

import java.time.LocalDate;
import java.util.ArrayList;

public class DateController {
    public ArrayList<Order> orderList(Workshop theWorkshop, LocalDate date){
        return theWorkshop.checkOrderByDate(date);
    }
}
