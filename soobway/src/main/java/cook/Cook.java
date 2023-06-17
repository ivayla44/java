package main.java.cook;

import main.java.order.*;
import main.java.order.ingredients.*;

import static java.lang.Thread.sleep;

public class Cook implements Runnable {
    String name;
    Order currentOrder;
    Thread cookThread;

    public Cook(String name) {
        this.name = name;
        currentOrder = null;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public String getName() {
        return name;
    }

    public void setCookThread(Thread cookThread) {
        this.cookThread = cookThread;
    }

    public Thread getCookThread() {
        return cookThread;
    }

    public void log(String message) {
        System.out.println("[Cook " + this.name + "] " + message);
    }


    @Override
    public void run() {
        while(true) {
            while (this.currentOrder == null) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (currentOrder) {
                for (Ingredient ingredient : currentOrder.getIngredients()) {
                    log("Adding " + ingredient.getName());
                    if (ingredient instanceof Bread) {
                        try {
                            sleep(1500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (ingredient instanceof Cheese) {
                        boolean bake = true;
                        try {
                            sleep(1200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if(currentOrder.getSpecialRequirements() != null) {
                            if (currentOrder.getSpecialRequirements().contains("no bake")) bake = false;
                        }
                        if (bake) {
                            log("Putting the sandwich in the oven.");
                            try {
                                sleep(2500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        try {
                            sleep(1200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                currentOrder.notify();
            }
            currentOrder.setFinalized(true);
            currentOrder = null;
        }
    }
}
