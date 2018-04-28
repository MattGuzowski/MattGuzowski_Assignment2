/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.baristamatic;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Matt Guzowski
 */
public class Inventory {

    private final Map<String, Integer> inventoryMap = new TreeMap();

    public Inventory() {

        inventoryMap.put("Coffee", 10);
        inventoryMap.put("Decaf Coffee", 10);
        inventoryMap.put("Sugar", 10);
        inventoryMap.put("Cream", 10);
        inventoryMap.put("Steamed Milk", 10);
        inventoryMap.put("Foamed Milk", 10);
        inventoryMap.put("Espresso", 10);
        inventoryMap.put("Cocoa", 10);
        inventoryMap.put("Whipped Cream", 10);
    }

    public int getIngredientInventory(String ingredient) {
        return inventoryMap.get(ingredient);
    }

    public void useIngredientInventory(String ingredient, int qty) {
        int ingredientInventory = inventoryMap.get(ingredient);
       
        ingredientInventory = ingredientInventory - qty;
        inventoryMap.put(ingredient, ingredientInventory);
    }
}
