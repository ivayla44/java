package main.java.oven;

import main.java.order.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Oven implements Runnable {
    Order orderInTheOven;
    List<Order> readyToCollect;

    public Oven() {
        readyToCollect = new ArrayList<>();
    }

    public Order getOrderInTheOven() {
        return orderInTheOven;
    }

    public void setOrderInTheOven(Order orderInTheOven) {
        this.orderInTheOven = orderInTheOven;
    }

    @Override
    public void run() {
        while(true) {
            while(orderInTheOven == null) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readyToCollect.add(orderInTheOven);
            orderInTheOven = null;
        }
    }
}
