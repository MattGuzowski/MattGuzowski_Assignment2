
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
        double result = menu.recipes.get("Cappuccino").getCost();
        double expResult = 2.90;
        assertEquals(result, expResult, 0);
    }

    /**
     * Test of addIngredient method, of class Recipe.
     */
    @Test
    public void testAddIngredient() {
        System.out.println("Testing addIngredient method in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);

        class myNewCoffee extends Recipe {

            public myNewCoffee(Inventory inventory) {
                super("myNewCoffee", inventory);
            }

            @Override
            public void setRecipe() {
                addIngredient("Coffee", 4); //should add 3.00 to cost
                addIngredient("Sugar", 2); // should add .50 to cost
            }
        }
        menu.addRecipe(new myNewCoffee(inventory));
        double result = menu.recipes.get("myNewCoffee").getCost();
        double expResult = 3.50;
        assertEquals(result, expResult, 0);
    }

    /**
     * Test of setRecipe method, of class Recipe.
     */
    @Test
    public void testSetRecipe() {
        System.out.println("testing setRecipe method in Recipe.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);

        class myNewCoffee extends Recipe {

            public myNewCoffee(Inventory inventory) {
                super("myNewCoffee", inventory);
            }

            @Override
            public void setRecipe() {
                addIngredient("Coffee", 4);
                addIngredient("Sugar", 2);
            }
        }
        menu.addRecipe(new myNewCoffee(inventory));
        String result = menu.recipes.get("myNewCoffee").name;
        String expResult = "myNewCoffee";
        assertEquals(result, expResult);
    }

    /**
     * Test of dispenseCoffee method, of class Recipe.
     */
    @Test
    public void testDispenseCoffee() {
        System.out.println("Testing dispenseCoffee in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);

        menu.makeDrink(2);

        PrintStream out = mock(PrintStream.class
        );
        System.setOut(out);
        menu.makeDrink(4);
        verify(out).println(startsWith("Dispensing:"));

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
        System.out.println("Testing isInStock method in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        boolean result = menu.recipes.get("Caffe Americano").isInStock();
        assertTrue(result);
        menu.makeDrink(0);
        menu.makeDrink(0);
        menu.makeDrink(0);
        boolean result2 = menu.recipes.get("Caffe Americano").isInStock();
        assertFalse(result2);

    }

    /**
     * Test of cost method, of class Recipe.
     */
    @Test
    public void testCost() {
        System.out.println("Testing cost in Recipe");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        double result = menu.recipes.get("Caffe Mocha").cost();
        double expResult = 335;
        assertEquals(result, expResult, 0);
    }
}
