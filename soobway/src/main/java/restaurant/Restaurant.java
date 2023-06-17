package main.java.restaurant;

import main.java.cook.*;
import main.java.order.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Restaurant implements Runnable {
    String name;
    List<Cook> cooks;
    List<Thread> cookThreads;
    List<Order> orders;

    public Restaurant(String name) {
        this.name = name;
        cooks = new ArrayList<>();
        cookThreads = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addCook(Cook cook) throws Exception {
        for(Cook c : cooks) {
            if(c.getName().equals(cook.getName())) {
                throw new Exception("This cook is already in this restaurant >:/");
            }
        }
        cooks.add(cook);
        System.out.println("Cook added :3");
        Thread newCook = new Thread(cook);
        cookThreads.add(newCook);
        cook.setCookThread(newCook);
        newCook.start();
    }

    public void removeCook(String name) throws Exception {
        for(Cook c : cooks) {
            if(c.getName().equals(name)) {
                c.getCookThread().interrupt();
                cookThreads.remove(c.getCookThread());
                cooks.remove(c);
                System.out.println("Cook removed.");
                return;
            }
        }
    }

    public void addOrder(Order order) throws Exception {
        if(order.isValid()) orders.add(order);
        else throw new Exception("This order is not valid :(");
    }

    public void finalizeOrder(Order order) throws Exception {
        synchronized (order) {
            order.wait();
            for(Order o : orders) {
                if(o.getID() == order.getID()) {
                    System.out.println("Order " + o.getID() + " is finalized and ready to collect :)");
                    return;
                }
            }
            throw new Exception("This order has not been submitted to this restaurant :0");
        }

    }

    void shutdown() throws Exception {
        for(Thread cook : cookThreads) {
            cook.interrupt();
        }
    }

    @Override
    public void run() {
        while(true) {
            Order giveOutOrder = null;
            while(giveOutOrder == null) {
                for(Order order : orders) {
                    if(!order.isFinalized()) {
                        giveOutOrder = order;
                    }
                }
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for(Cook cook : cooks) {
                if(cook.getCurrentOrder() == null) {
                    cook.setCurrentOrder(giveOutOrder);
                    try {
                        finalizeOrder(giveOutOrder);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return;
                }
            }
        }
    }
}
