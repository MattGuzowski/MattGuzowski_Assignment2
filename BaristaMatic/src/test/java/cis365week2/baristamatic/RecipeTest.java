/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.baristamatic;

import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Matt Guzowski
 */
public class RecipeTest {
    
    public RecipeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCost method, of class Recipe.
     */
    @Test
    public void testGetCost() {
        System.out.println("Testing getCost method in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        double result = menu.recipes.get("CoffeeRecipe").getCost();
        double expResult = 2.75;
        assertEquals(result, expResult,0);
    }

    /**
     * Test of addIngredient method, of class Recipe.
     */
    @Test
    public void testAddIngredient() {
        System.out.println("Testing addIngredient method in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        Recipe mockRecipe = mock(Recipe.class);
        Drink mockDrink = mock(Drink.class);
        
        when(mockDrink.getDescription()).thenReturn("Drink");
        assertTrue(mockDrink.getDescription().equals("Drink"));
        
    }

    /**
     * Test of setRecipe method, of class Recipe.
     */
    @Test
    public void testSetRecipe() {
        System.out.println("testing setRecipe method in Recipe.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);q

    }

    /**
     * Test of dispenseCoffee method, of class Recipe.
     */
    @Test
    public void testDispenseCoffee() {
        System.out.println("dispenseCoffee");

    }

    /**
     * Test of outOfStock method, of class Recipe.
     */
    @Test
    public void testOutOfStock() {
        System.out.println("Testing outOfStock method in Recipe.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        
        menu.makeDrink(4);
        menu.makeDrink(4);
        menu.makeDrink(4); //run down inventory
        
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        menu.makeDrink(4);
        verify(out).println(startsWith("Out of Stock:"));
    }

    /**
     * Test of makeDrink method, of class Recipe.
     */
    @Test
    public void testMakeDrink() {
        System.out.println("Testing makeDrink method in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        menu.makeDrink(4);
        //int result = inventory.quantities.get("Coffee");
        int result = inventory.quantities.get("Coffee");
        int expResult = 7;
        assertEquals(result, expResult);
        System.out.println(result);
    }

    /**
     * Test of isInStock method, of class Recipe.
     */
    @Test
    public void testIsInStock() {
        System.out.println("isInStock");
    
    }

    /**
     * Test of cost method, of class Recipe.
     */
    @Test
    public void testCost() {
        System.out.println("cost");
    
    }

    
}
