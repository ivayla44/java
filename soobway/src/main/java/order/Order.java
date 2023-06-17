package main.java.order;

import main.java.order.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int setID;
    int ID;
    boolean isFinalized;
    List<Ingredient> ingredients;
    List<String> specialRequirements;

    public Order() {
        this.ID = setID;
        setID++;
        this.isFinalized = false;
        this.ingredients = new ArrayList<>();
    }

    public Order(List<Ingredient> ingredients) {
        this.ID = setID;
        setID++;
        this.isFinalized = false;
        this.ingredients = ingredients;
        this.specialRequirements = new ArrayList<>();
    }

    public Order(List<Ingredient> ingredients, List<String> specialRequirements) {
        this.ID = setID;
        setID++;
        this.isFinalized = false;
        this.ingredients = ingredients;
        this.specialRequirements = specialRequirements;
    }

    public int getID() {
        return ID;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getSpecialRequirements() {
        return specialRequirements;
    }

    public void makeClassicHam(Bread typeOfBread) {
        List<Ingredient> classicHamIngredients = new ArrayList<>();
        classicHamIngredients.add(typeOfBread);
        Meat ham = new Meat("Ham");
        classicHamIngredients.add(ham);
        Cheese cheese = new Cheese("Cheese");
        classicHamIngredients.add(cheese);
        Topping tomato = new Topping("Tomato");
        classicHamIngredients.add(tomato);
        Topping onion = new Topping("Onion");
        classicHamIngredients.add(onion);
        Topping cucumber = new Topping("Cucumber");
        classicHamIngredients.add(cucumber);
        Sauce mayo = new Sauce("Mayo");
        classicHamIngredients.add(mayo);
        this.ingredients = classicHamIngredients;
    }

    public void makeLongBurger(Bread typeOfBread) {
        List<Ingredient> longBurgerIngredients = new ArrayList<>();
        longBurgerIngredients.add(typeOfBread);
        Meat veal = new Meat("Veal");
        longBurgerIngredients.add(veal);
        Cheese creamCheese = new Cheese("Creamcheese");
        longBurgerIngredients.add(creamCheese);
        Topping icebergLettuce = new Topping("Iceberglettuce");
        longBurgerIngredients.add(icebergLettuce);
        Topping pickles = new Topping("Pickles");
        longBurgerIngredients.add(pickles);
        Sauce bbq = new Sauce("BBQ");
        longBurgerIngredients.add(bbq);
        this.ingredients = longBurgerIngredients;
    }

    public void makeVeggieDelight(Bread typeOfBread) {
        List<Ingredient> veggieDelightIngredients = new ArrayList<>();
        veggieDelightIngredients.add(typeOfBread);
        Cheese cheese = new Cheese("Cheese");
        veggieDelightIngredients.add(cheese);
        Topping icebergLettuce = new Topping("Iceberglettuce");
        veggieDelightIngredients.add(icebergLettuce);
        Topping olives = new Topping("Olives");
        veggieDelightIngredients.add(olives);
        Topping tomato = new Topping("Tomato");
        veggieDelightIngredients.add(tomato);
        Sauce ranch = new Sauce("Ranch");
        veggieDelightIngredients.add(ranch);
        this.ingredients = veggieDelightIngredients;
    }

    public boolean isValid() {
        int bread = 0, meat = 0, cheese = 0, toppings = 0, sauces = 0;
        for(Ingredient ingr : ingredients) {
            int index = ingredients.indexOf(ingr);
            if(ingr instanceof Bread && index == 0) {
                bread++;
                continue;
            }
            if(ingr instanceof Meat && index == 1) {
                meat++;
                continue;
            }
            if(ingr instanceof Cheese && (index == 1 || index == 2)) {
                cheese++;
                continue;
            }
            if(ingr instanceof Topping && (index == 2 || index == 3 || index == 4 || index == 5)) {
                toppings++;
                continue;
            }
            if(ingr instanceof Sauce && (index == 5 || index == 6 || index == 7 || index == 8)) {
                sauces++;
            }
        }
        return (bread == 1 && (meat == 0 || meat == 1) && cheese == 1 && (toppings > 0 && toppings < 4) && (sauces > 0 && sauces < 4));
    }
}
