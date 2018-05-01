
package cis365week2.baristamatic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    public IngredientTest() {
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
     * Test of getDescription method, of class Ingredient.
     */
    @Test
    public void testGetDescription() {
        System.out.println("Testing getDescription in Ingredient");
        Drink Coffee = new Drink("Coffee");
        Coffee = (new Coffee()).addTo(Coffee);
        assertTrue(Coffee.getDescription().equals(("Coffee")));

    }

    /**
     * Test of getName method, of class Ingredient.
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName in Ingredient.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        String result = inventory.ingredients.get("Coffee").getName();
        System.out.println(result);
        String expResult = "Coffee";
        assertEquals(result, expResult);
    }

    /**
     * Test of addTo method, of class Ingredient.
     */
    @Test
    public void testAddTo() {
        System.out.println("Testing addTo in Ingredient.");
        Drink Coffee = new Drink("Coffee");
        Coffee = (new Coffee()).addTo(Coffee);
        assertTrue(Coffee.getDescription().equals(("Coffee"))
                && Coffee.cost() == 75);
    }

    /**
     * Test of cost method, of class Ingredient.
     */
    @Test
    public void testCost() {
        System.out.println("Testing cost in Ingredient.");
        Drink Cream = new Drink("Cream");
        Cream = (new Cream()).addTo(Cream);
        assertTrue(Cream.cost() == 25);
    }
}
