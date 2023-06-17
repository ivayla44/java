import main.java.cook.*;
import main.java.order.Order;
import main.java.order.ingredients.*;
import main.java.restaurant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void runMenu(Restaurant restaurant) {
        Scanner sc = new Scanner(System.in);
        String[] options = {"1. Add cook", "2. Remove cook", "3. Make order", "4. Check order state", "5. Exit"};
        System.out.println("Please enter the number of the action you want to make :)");
        int option = 0;
        while(option != 5) {
            for (String each : options) {
                System.out.println(each);
            }
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("Enter the name of the new cook:");
                        String name = sc.next();
                        Cook newCook = new Cook(name);
                        restaurant.addCook(newCook);
                    }
                    case 2 -> {
                        System.out.println("Enter the name of the cook you want to remove:");
                        String name = sc.next();
                        restaurant.removeCook(name);
                    }
                    case 3 -> {
                        Order order = new Order();
                        List<Ingredient> newOrderIngredients = new ArrayList<>();
                        System.out.println("Please pick what kind of bread you want:");
                        String bread = sc.next();
                        newOrderIngredients.add(new Bread(bread));
                        System.out.println("For your sandwich we have a couple of options:");
                        String[] sandwichOptions = {"1. Classic Ham", "2. Long Burger", "3. Veggie Delight", "4. Make it yourself"};
                        for (String opt : sandwichOptions) {
                            System.out.println(opt);
                        }
                        int sandwichOption = sc.nextInt();
                        switch (sandwichOption) {
                            case 1 -> order.makeClassicHam(new Bread(bread));
                            case 2 -> order.makeLongBurger(new Bread(bread));
                            case 3 -> order.makeVeggieDelight(new Bread(bread));
                            case 4 -> {
                                System.out.println("What do you want to add? You can add a type of meat, cheese or creamcheese, 1 to 3 toppings and 1 to 3 sauces:");
                                String[] toppingOptions = {"1. Meat", "2. Cheese", "3. Topping", "4. Sauce", "5. Submit order"};
                                int toppingOption = 0;
                                String name;
                                while (toppingOption != 5) {
                                    for (String toppingOpt : toppingOptions) {
                                        System.out.println(toppingOpt);
                                    }
                                    toppingOption = sc.nextInt();
                                    switch (toppingOption) {
                                        case 1 -> {
                                            System.out.println("What type of meat do you want?");
                                            name = sc.next();
                                            newOrderIngredients.add(new Meat(name));
                                        }
                                        case 2 -> {
                                            System.out.println("What type of cheese do you want?");
                                            name = sc.next();
                                            newOrderIngredients.add(new Cheese(name));
                                        }
                                        case 3 -> {
                                            System.out.println("What type of topping do you want?");
                                            name = sc.next();
                                            newOrderIngredients.add(new Topping(name));
                                        }
                                        case 4 -> {
                                            System.out.println("What type of sauce do you want?");
                                            name = sc.next();
                                            newOrderIngredients.add(new Sauce(name));
                                        }
                                    }
                                }
                                order = new Order(newOrderIngredients);
                            }
                        }
                        System.out.println("Do you have any special requirements for your sandwich? [y / n]");
                        String answ = sc.next();
                        List<String> specialRequirements = new ArrayList<>();
                        while (answ.equals("y")) {
                            System.out.println("Do you have any special requirements for your sandwich? [y / n]");
                            String newRequirement = sc.nextLine();
                            specialRequirements.add(newRequirement);
                            answ = sc.next();
                        }
                        if (!specialRequirements.isEmpty()) order = new Order(newOrderIngredients, specialRequirements);
                        restaurant.addOrder(order);
                    }
                    case 4 -> {
                        System.out.println("Enter the ID of the order you want to trace:");
                        int ID = sc.nextInt();
                        for (Order o : restaurant.getOrders()) {
                            if (o.getID() == ID) {
                                if (o.isFinalized())
                                    System.out.println("This order is finalized and ready to collect :)");
                                else System.out.println("Your order is still being processed");
                            }
                        }
                    }
                    case 5 -> exit(0);
                }
            } catch (Exception e) {
                System.out.println("Wrong input! Please try again :<)");
                runMenu(restaurant);
            }
        }
    };

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Soobway");
        Thread soobway = new Thread(restaurant);
        soobway.start();

        runMenu(restaurant);
    }
}