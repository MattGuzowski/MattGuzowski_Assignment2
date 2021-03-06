/*
 * code modified from https://github.com/stuff-and-exercises/barista-matic
 * modified to practice unit tests
 */
package cis365week2.baristamatic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Recipe {

    public Map<String, Integer> recipe;
    public final String name;
    public double cost;

    protected Inventory inventory;

    public Recipe(String nameIn, Inventory inventoryIn) {
        inventory = inventoryIn;
        name = nameIn;
        recipe = new HashMap<String, Integer>();
        setRecipe();
        cost = (double) cost() / 100;
    }

    public double getCost() {
        return cost;
    }

    public void addIngredient(String ingredientIn, int qtyIn) {
        recipe.put(ingredientIn, qtyIn);
    }

    // Every new recipe has to specify the ingredients that will be using
    public abstract void setRecipe();

    public void dispenseCoffee() {
        System.out.println("Dispensing: " + name);
    }

    public void outOfStock() {
        System.out.println("Out of Stock: " + name);
    }

    public Drink makeDrink() {
        Drink drink;
        if (isInStock()) {
            drink = new Drink(name);
            for (Entry<String, Integer> ingredient : recipe.entrySet()) {
                for (int i = 0; i < ingredient.getValue(); i++) {
                    drink = inventory.get(ingredient.getKey()).addTo(drink);
                }
            }
            dispenseCoffee();
            return drink;
        } else {
            outOfStock();
            return null;
        }
    }

    public boolean isInStock() {
        for (Entry<String, Integer> ingredient : recipe.entrySet()) {
            if (!inventory.enoughOf(ingredient.getKey(), ingredient.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int cost() {
        int cost = 0;
        for (Entry<String, Integer> ingredient : recipe.entrySet()) {
            for (int i = 0; i < ingredient.getValue(); i++) {
                cost += inventory.getCost(ingredient.getKey());
            }
        }
        return cost;
    }

}

class CoffeeRecipe extends Recipe {

    public CoffeeRecipe(Inventory inventory) {
        super("Coffee", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Coffee", 3);
        addIngredient("Sugar", 1);
        addIngredient("Cream", 1);
    }

}

class DecafCoffeeRecipe extends Recipe {

    public DecafCoffeeRecipe(Inventory inventory) {
        super("Decaf Coffee", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Decaf Coffee", 3);
        addIngredient("Sugar", 1);
        addIngredient("Cream", 1);
    }

}

class CaffeLatteRecipe extends Recipe {

    public CaffeLatteRecipe(Inventory inventory) {
        super("Caffe Latte", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Espresso", 2);
        addIngredient("Steamed Milk", 1);
    }

}

class CaffeAmericanoRecipe extends Recipe {

    public CaffeAmericanoRecipe(Inventory inventory) {
        super("Caffe Americano", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Espresso", 3);
    }

}

class CaffeMochaRecipe extends Recipe {

    public CaffeMochaRecipe(Inventory inventory) {
        super("Caffe Mocha", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Espresso", 1);
        addIngredient("Cocoa", 1);
        addIngredient("Steamed Milk", 1);
        addIngredient("Whipped Cream", 1);
    }

}

class CappuccinoRecipe extends Recipe {

    public CappuccinoRecipe(Inventory inventory) {
        super("Cappuccino", inventory);
    }

    @Override
    public void setRecipe() {
        addIngredient("Espresso", 2);
        addIngredient("Steamed Milk", 1);
        addIngredient("Foamed Milk", 1);
    }

}
