
package cis365week2.baristamatic;

import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Matt Guzowski
 */
public class InventoryTest {

    Inventory inventory;

    public InventoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @After
    public void tearDown() {
        inventory = null;
    }

    /**
     * Test of display method, of class Inventory.
     */
    @Test
    public void testDisplay() {
        System.out.println("Testing Inventory display");
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        inventory.display();
        verify(out).println(startsWith("Inventory:"));//mocking the display
    }

    /**
     * Test of restock method, of class Inventory.
     */
    @Test
    public void testRestock() {
        System.out.println("Testing restock method in Inventory");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        menu.makeDrink(4);
        int result = inventory.quantities.get("Coffee");
        assertEquals(result, 7);
        inventory.restock();
        result = inventory.quantities.get("Coffee");
        assertEquals(result, 10);
    }

    /**
     * v
     * Test of loadIngredient method, of class Inventory.
     */
    @Test
    public void testLoadIngredient() {
        System.out.println("Testing loadIngredient in Inventory.");
        Ingredient ingredient = null;
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        int result = inventory.quantities.get("Coffee");
        assertEquals(result, 10);

    }

    /**
     * Test of enoughOf method, of class Inventory.
     */
    @Test
    public void testEnoughOf() {
        System.out.println("Testing enoughOf method in Inventory.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        Ingredient ingredient = inventory.get("Coffee");
        boolean result = inventory.enoughOf("Coffee", 10);
        assertFalse(result);

    }

    /**
     * Test of get method, of class Inventory.
     */
    @Test
    public void testGet() {
        System.out.println("testing get method in Inventory");
        Ingredient ingredient = inventory.get("Coffee");
        String result = ingredient.getName();
        String expResult = "Coffee";
        assertEquals(expResult, result);

        ingredient = inventory.get("Decaf Coffee");
        result = ingredient.getName();
        expResult = "Decaf Coffee";
        assertEquals(expResult, result);

        ingredient = inventory.get("Sugar");
        result = ingredient.getName();
        expResult = "Sugar";
        assertEquals(expResult, result);

        ingredient = inventory.get("Cream");
        result = ingredient.getName();
        expResult = "Cream";
        assertEquals(expResult, result);

        ingredient = inventory.get("Steamed Milk");
        result = ingredient.getName();
        expResult = "Steamed Milk";
        assertEquals(expResult, result);

        ingredient = inventory.get("Foamed Milk");
        result = ingredient.getName();
        expResult = "Foamed Milk";
        assertEquals(expResult, result);

        ingredient = inventory.get("Espresso");
        result = ingredient.getName();
        expResult = "Espresso";
        assertEquals(expResult, result);

        ingredient = inventory.get("Cocoa");
        result = ingredient.getName();
        expResult = "Cocoa";
        assertEquals(expResult, result);

        ingredient = inventory.get("Whipped Cream");
        result = ingredient.getName();
        expResult = "Whipped Cream";
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class Inventory.
     */
    @Test
    public void testGetInventoryIngredientCost() {
        System.out.println("Testing Ingredient getCost");

        String ingredient = "Coffee";
        int result = inventory.getCost(ingredient);
        int expResult = 75;
        assertEquals(expResult, result);

        ingredient = "Decaf Coffee";
        result = inventory.getCost(ingredient);
        expResult = 75;
        assertEquals(expResult, result);

        ingredient = "Sugar";
        result = inventory.getCost(ingredient);
        expResult = 25;
        assertEquals(expResult, result);

        ingredient = "Cream";
        result = inventory.getCost(ingredient);
        expResult = 25;
        assertEquals(expResult, result);

        ingredient = "Steamed Milk";
        result = inventory.getCost(ingredient);
        expResult = 35;
        assertEquals(expResult, result);

        ingredient = "Foamed Milk";
        result = inventory.getCost(ingredient);
        expResult = 35;
        assertEquals(expResult, result);

        ingredient = "Espresso";
        result = inventory.getCost(ingredient);
        expResult = 110;
        assertEquals(expResult, result);

        ingredient = "Cocoa";
        result = inventory.getCost(ingredient);
        expResult = 90;
        assertEquals(expResult, result);

        ingredient = "Whipped Cream";
        result = inventory.getCost(ingredient);
        expResult = 100;
        assertEquals(expResult, result);
    }

}
